class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res=new int[n];

        int moves=0;
        int balls=0;
        for(int i=0;i<n;i++){
            char c=boxes.charAt(i);
            res[i]=moves+balls;
            moves=res[i];
            if(c=='1') balls++;
        }

        moves=0;balls=0;
        for(int i=n-1;i>=0;i--){
            char c=boxes.charAt(i);
            int sum=moves+balls;
            res[i]+=sum;
            moves=sum;
            if(c=='1') balls++;
        }

        return res;
    }
}