// Question : https://leetcode.com/problems/split-array-into-consecutive-subsequences/


import java.util.*;
class Solution {
    public boolean isPossible(int[] nums) {
        // int n=nums.length;
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> required = new HashMap<Integer,Integer>();
        
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        
        for(int num:nums){
            if(count.get(num)==0) continue;
            if(required.getOrDefault(num,0)>0){
                required.put(num,required.get(num)-1);
                required.put(num+1,required.getOrDefault(num+1,0)+1);
                count.put(num,count.get(num)-1);
            }else if(count.get(num)>0 && count.getOrDefault(num+1,0)>0 && count.getOrDefault(num+2,0)>0){
                count.put(num,count.get(num)-1);
                count.put(num+1,count.get(num+1)-1);
                count.put(num+2,count.get(num+2)-1);
                required.put(num+3,required.getOrDefault(num+3,0)+1);
            }else{
                return false;
            }
        }
        return true;
    }
}