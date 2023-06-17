package com.dawn.common.utils.dataStructures.stringMatch;


import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description:字符串朴素模式匹配算法
 * @Date 2021-4-1 , 0001 21:05
 * @Author kousq
 */
public class SimplicityPatternMatch {

    /**
     * 从0算起，返回子串在母串中第一次出现的位置
     * @param mainS
     * @param subS
     * @return
     */
    public static int subStringIndex(String mainS, String subS){
        int i = 0;
        String sub  = "";
        while ( i <= mainS.length()-subS.length()+1){
            sub = StrUtil.subWithLength(mainS,i,subS.length());
            if(StringUtils.compare(sub,subS) != 0){
                ++i;
            }else {
                return i;
            }
        }
        return -1;
    }


    public static int subCharArrayIndex(String mainS, String subS){
        int i = 0,j = 0;
        //String 字符数组第一位从0算
        while ( i < mainS.length() && j < subS.length()){
            if(mainS.charAt(i) == subS.charAt(j)){
                ++i;++j;
            }else {
                i = i-j+1;
                j=0;
            }
        }
        if(j >= subS.length()){
            return i - subS.length();
        }else{
            return -1;
        }
    }


    public static void main(String[] args) {
        String str = "googggfyguyfitglegooglegooglo";
        String s = "google";
        System.err.println(subStringIndex(str, s));
        System.err.println(subCharArrayIndex(str, s));
        System.err.println(StrUtil.subWithLength(str,subCharArrayIndex(str,s),s.length()));
        System.err.println(StrUtil.subWithLength(str,subStringIndex(str,s),s.length()));

    }
}
