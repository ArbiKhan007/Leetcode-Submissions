class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int mpre,gpre,ppre;
        int n=garbage.length;
        mpre=0;gpre=0;ppre=0;
        int res=0;

        for(int i=0;i<n;i++){
            for(char c:garbage[i].toCharArray()){
                if(c=='G') gpre++;
                else if(c=='M') mpre++;
                else ppre++;
            }
        }

        for(int i=0;i<n;i++){
            res+=garbage[i].length();
            if(i!=0&&mpre>0) res+=travel[i-1];
            if(i!=0&&gpre>0) res+=travel[i-1];
            if(i!=0&&ppre>0) res+=travel[i-1];

            for(char c:garbage[i].toCharArray()){
                if(c=='G') gpre--;
                else if(c=='M') mpre--;
                else ppre--;
            }
        }

        return res;
    }
}