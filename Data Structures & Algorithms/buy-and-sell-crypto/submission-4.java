class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int left = 0, right = 1;
        
        while(right < prices.length) {
            if(prices[left] < prices[right]){
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
