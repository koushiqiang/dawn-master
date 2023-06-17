package com.dawn.common.utils.dataStructures.stringMatch;

import cn.hutool.core.util.StrUtil;

/**
 * @Description:字符串的KMP匹配算法，串指针不回溯，整体时间复杂度为 O(主串长度+模式串长度)量级
 * @Date 2021-4-2 , 0002 0:05
 * @Author kousq
 */
public class KMPPatternMatch {


    public static int subCharArrayKMPIndex(String mainS,String subS){

        int i = 0, j = 0;
        //String 字符数组第一位从0算
        int[]  next = new int[subS.length()+1];
        getNextVal(subS,next);
        while ( i < mainS.length() && j < subS.length()){
            if(j ==0 || mainS.charAt(i) == subS.charAt(j)){
                ++i;++j;
            }else {
                j = next[j];
            }
        }
        if(j >= subS.length()){
            return i - subS.length();
        }else{
            return -1;
        }
    }


    /**
     * 为防止模式串中前缀和后缀中有多个相同字符，造成模式串指针无效回溯，
     * 将next数组优化为nextVal数组
     * @param subS
     * @param next
     */
    public static void getNextVal(String subS,int next[]){
        if(next.length > 0 ){
            getNext(subS,next);
            int[] nextval = new int[next.length];
            nextval[0] = 0;
            for(int j = 1;j <subS.length();j++){
                if(subS.charAt(next[j]) == subS.charAt(j)){
                    nextval[j] = nextval[next[j]];
                }else {
                    nextval[j] = next[j];
                }
            }
        }


    }


    /**
     * 获取模式串的Next数组
     * @param subS
     * @param next
     *
     */
    public static void getNext(String subS,int next[]){
        int i = 1,j = 0;
        next[0] = 0;
        while(i < subS.length()-1){
            if( j == 0 || subS.charAt(i) ==subS.charAt(j)){
                ++i;++j;
                next[i] = j;
            }else {
                j = next[j];
            }

        }
    }

    public static void main(String[] args) {
        String str = "googhuihiugoogleiggflo";
        String s = "eiggflo";
        System.err.println(subCharArrayKMPIndex(str, s));
        System.err.println(StrUtil.subWithLength(str,subCharArrayKMPIndex(str,s),s.length()));
        System.err.println(StrUtil.subWithLength(str,0,s.length()));
    }
}
