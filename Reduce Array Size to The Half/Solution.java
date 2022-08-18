
import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(count.get(arr[i])==null){
                count.put(arr[i],0);
            }
            count.put(arr[i],count.get(arr[i])+1);
        }
        
        int cnt=0,rm=arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
        for(Integer key:count.keySet()){
            pq.add(count.get(key));
        }
        
        while(pq.isEmpty()==false && rm>arr.length/2){
            rm-=pq.poll();
            cnt++;
        }
        return cnt;
    }
}