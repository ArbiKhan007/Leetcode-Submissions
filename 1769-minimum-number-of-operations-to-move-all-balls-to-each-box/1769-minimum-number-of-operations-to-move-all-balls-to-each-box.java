class Solution {
    public int[] minOperations(String boxes) {
        int[] res=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++){
            int dist=0;
            for(int j=i-1;j>=0;j--){
                if(boxes.charAt(j)=='1') dist+=i-j;
            }

            for(int j=i+1;j<boxes.length();j++){
                if(boxes.charAt(j)=='1') dist+=j-i;
            }
            res[i]=dist;
        }

        return res;
    }
}