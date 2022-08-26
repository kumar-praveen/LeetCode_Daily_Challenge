// Question : https://leetcode.com/problems/reordered-power-of-2/

import java.util.*;

class Solution {
    public boolean matchAll(String num1,String num2){
        int count[]=new int[26];
        for(int i=0;i<num1.length();i++){
            count[num1.charAt(i)-'0']++;
        }
        for(int i=0;i<num2.length();i++){
            count[num2.charAt(i)-'0']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
    public boolean reorderedPowerOf2(int n) {
        if(n==1) return true;
        if(n==0) return false;
        
        long val=1;
        HashSet<String> allPower = new HashSet<String>();
        while(val*2<=1e9){
            val*=2;
            allPower.add(String.valueOf(val));
        }
        
        String num = String.valueOf(n);
        for(String curr:allPower){
            if(matchAll(curr,num)) return true;
        }
        return false;
    }
}