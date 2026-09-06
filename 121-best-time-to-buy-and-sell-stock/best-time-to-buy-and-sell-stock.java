class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bp = prices[0];
        int maxPro = 0;

        for(int i=1; i<n; i++){
            if(bp < prices[i]) {
               maxPro = Math.max(maxPro,  prices[i] - bp);
            } else {
                bp = prices[i];
            }
        }
         return maxPro;
    }
}