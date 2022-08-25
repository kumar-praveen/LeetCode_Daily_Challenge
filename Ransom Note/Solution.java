// Question : https://leetcode.com/problems/ransom-note/

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> count= new HashMap<Character,Integer>();
        for(int i=0;i<magazine.length();i++){
            if(count.get(magazine.charAt(i))==null){
                count.put(magazine.charAt(i),0);
            }
            count.put(magazine.charAt(i),count.get(magazine.charAt(i))+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            if(count.get(ransomNote.charAt(i))==null || count.get(ransomNote.charAt(i))==0) return false;
            count.put(ransomNote.charAt(i),count.get(ransomNote.charAt(i))-1);
        }
        return true;
    }
}