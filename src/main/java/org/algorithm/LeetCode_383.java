// https://leetcode.cn/problems/ransom-note/
package org.algorithm;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
        * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        * 如果可以，返回 true ；否则返回 false;
        * magazine 中的每个字符只能在 ransomNote 中使用一次
        * */

        /*
        * 思路
        * 由于字符串只有小写英文字母组成，考虑数组哈希表
        * */

        Map<Character,Integer> hashTable = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            hashTable.put(c, hashTable.getOrDefault(c, 0) + 1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(! hashTable.containsKey(c)){
                return false;
            }
            else{
                if(hashTable.get(c) < 1) return false;
                hashTable.put(c, hashTable.get(c) - 1);
            }
        }
        return true;
    }
}
