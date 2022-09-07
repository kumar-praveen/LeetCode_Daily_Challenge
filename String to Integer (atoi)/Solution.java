class Solution {
    public int myAtoi(String str) {
        str = str.strip();
        if(str.equals("")) return 0;
        int n=str.length(),pos=1,st=0;
        pos=str.charAt(0)=='-' ? 0 : 1;
        st=str.charAt(0)=='-' || str.charAt(0)=='+' ? 1 : 0;

        long val=0;
        while(st<n && str.charAt(st)>='0' && str.charAt(st)<='9'){
            val=val*10+str.charAt(st)-'0';
            if(pos==0 && -1*val<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(pos==1 && val>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            st++;
        }
        if(pos==0) return (int)(-1*val);
        return (int)val;
    }
}