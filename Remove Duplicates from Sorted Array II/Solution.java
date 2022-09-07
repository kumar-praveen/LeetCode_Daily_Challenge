// Question : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length,i=0,j=0;
        while(i<n){
            int cnt=1,val=nums[i++];
            while(i<n && val==nums[i]){
                i++;cnt++;
            }
            cnt=Math.min(cnt,2);
            while(cnt--!=0){
                nums[j++]=val;
            }
        }
        return j;
    }
}