package com.neutrino.dawn.model;


import com.dawn.common.annotation.Excel;
import com.dawn.common.annotation.Excels;
import java.util.Date;
import lombok.Data;

/**
 * 用户对象 sys_user
 *
 */
@Data
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "用户序号", prompt = "用户编号")
    private Long userId;

    @Excel(name = "部门编号", type = Excel.Type.IMPORT)
    private Long deptId;

    //父部门编号
    private Long parentId;

    @Excel(name = "登录名称")
    private String loginName;

    @Excel(name = "用户名称")
     private String userName;

    @Excel(name = "用户邮箱")
     private String email;

    @Excel(name = "手机号码")
    private String phonenumber;

    @Excel(name = "用户性别", readConverterExp = "0=男,1=女")
     private String sex;

    private String avatar;

    private String password;

    private String salt;

    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private String delFlag;


    @Excel(name = "最后登陆时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
     private Date loginDate;

    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT)
    })
    private SysDept dept;

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

}
