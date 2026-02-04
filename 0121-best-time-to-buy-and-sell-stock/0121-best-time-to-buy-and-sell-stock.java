class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxProf=0;

        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i], min);
            if(prices[i]-min<0){
                maxProf=prices[i];
                continue;
            }

            maxProf=Math.max(maxProf, prices[i]-min);
        }

        return maxProf;
    }
}