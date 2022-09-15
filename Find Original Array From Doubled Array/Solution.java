
// Question : https://leetcode.com/problems/find-original-array-from-doubled-array/

import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int n=changed.length;
        if((n&1)==1) return new int[0];
        
        for(int i=0;i<n;i++){
            count.put(changed[i],count.getOrDefault(changed[i],0)+1);
        }
        Arrays.sort(changed);
        
        for(int i=n-1;i>=0;i--){
            int num=changed[i],half=changed[i]/2;
            if(num%2==0 && count.get(half)!=null && count.get(num)!=null){
                
                count.put(num,count.getOrDefault(num,0)-1);
                if(count.get(num)==0) count.remove(num);
                
                if(count.get(half)!=null){
                    count.put(half,count.getOrDefault(half,0)-1);
                    if(count.get(half)==0) count.remove(half);
                    arr.add(half);
                }

                if(arr.size()==n/2) break;
            }
        }
        if(arr.size()!=n/2) return new int[0];
        int ans[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++) ans[i]=arr.get(i);
        return ans;
    }
}