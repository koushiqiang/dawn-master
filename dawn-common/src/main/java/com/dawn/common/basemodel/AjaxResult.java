package com.dawn.common.basemodel;

import cn.hutool.core.util.ObjectUtil;
import java.util.HashMap;

/**
 * Package: com.dawn.common.basemodel Description: 返回ajax操作消息 Date:  2020/5/17 15:17 Author: kousq
 * Modified By:
 */
public class AjaxResult extends HashMap<String, Object> {

    public static final long serialVersionUID = 1L;

    private static final String CODE_TAG = "code";

    private static final String MSG_TAG = "msg";

    private static final String DATA_TAG = "data";
    /**
     *类型
     */
    private transient ResultType type;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private transient Object data;

    /**
     * @description:状态类型
     * @param:
     * @return:
     * @auther: kousq
     * @date: 2020/5/17 15:21
     */
    public enum ResultType {
        /**
         * 成功
         */
        SUCCESS(200),
        /**
         * 警告
         */
        WARN(301),
        /**
         * 错误
         */
        ERROR(500);
        private final int value;

        ResultType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    //初始化一个新创建的 AjaxResult 对象，使其表示一个空消息
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     */
    public AjaxResult(ResultType type, String msg) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     * @param data 数据对象
     */
    public AjaxResult(ResultType type, String msg, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (ObjectUtil.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 方法重载----返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    public static AjaxResult success(Object data){
        return AjaxResult.success("操作成功", data);
    }


    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(ResultType.SUCCESS, msg, data);
    }


    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String msg) {
        return AjaxResult.warn(msg, null);
    }

    public static AjaxResult warn(String msg, Object data) {
        return new AjaxResult(ResultType.WARN, msg, data);
    }


    /**
     * 返回错误消息--重载
     *
     * @return 默认错误信息
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(ResultType.ERROR, msg, data);
    }
}
