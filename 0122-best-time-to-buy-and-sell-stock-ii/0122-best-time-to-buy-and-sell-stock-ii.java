class Solution {
    public int maxProfit(int[] prices) {
        int prof=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-min>0){
                prof+=prices[i]-min;
            }
            
            min=prices[i];
        }

        return prof;
    }
}