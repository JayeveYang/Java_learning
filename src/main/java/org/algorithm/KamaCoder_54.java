package org.algorithm;

import java.util.Scanner;

public class KamaCoder_54 {
    //static 方法里面只能调用static方法
    /*
    * 题目
    * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
    * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
    * */
    public static String replaceNumber(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z')
                res+=s.charAt(i);
            else
                res+="number";
        }
        return  res;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.print(replaceNumber(scan.next()));
    }
}
