
class Solution{
    public String largestPalindromic(String num) {
        int index[]=new int[10];
        for(int i=0;i<num.length();i++){
            index[num.charAt(i)-'0']++;
        }
        int flag=0;
        StringBuilder ans = new StringBuilder();
        for(int i=9;i>0;i--){
            int cnt=(index[i]/2)*2;
            char ch=(char)((int)('0')+i);
            StringBuilder temp = new StringBuilder();
            while(cnt!=0){
                temp.append(ch);
                temp.append(ch);
                cnt-=2;
            }
            ans.insert(ans.length()/2,temp.toString());
            if(index[i]%2==1) flag=1;
        }
       
        if(flag==1){
            for(int i=9;i>0;i--){
                if(index[i]%2==1){
                    ans.insert(ans.length()/2,(char)((int)('0')+i));
                    break;
                }
            }
        }
        
        if(index[0]==1 && ans.length()%2==1) return ans.toString();
        if(index[0]==1 && ans.length()%2==0){
            return ans.insert(ans.length()/2,'0').toString();
        }
        if(index[0]==num.length()) return "0";
        if(ans.length()==1) return ans.toString();
        int cnt=(index[0]/2)*2;
        while(cnt!=0){
            cnt-=2;
            int i=ans.length()/2;
            int j=(ans.length()+1)/2+1;
            ans.insert(i,'0');
            ans.insert(j,'0');
        }
        if(index[0]%2==1 && ans.length()%2==0) ans.insert(ans.length()/2,'0');
        return ans.toString();
        
    }
}