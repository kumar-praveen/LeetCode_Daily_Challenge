// Question : https://leetcode.com/problems/subsets/

import java.util.*;

class Solution {
    private void powerSet(List<List<Integer>> list,List<Integer> temp,int i,int nums[]){
        if(i==nums.length){
            list.add(temp);
            return;
        }
        powerSet(list,new ArrayList<Integer>(temp),i+1,nums);
        temp.add(nums[i]);
        powerSet(list,temp,i+1,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        powerSet(ans,new ArrayList<Integer>(),0,nums);
        return ans;
    }
}