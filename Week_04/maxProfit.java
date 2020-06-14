class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length;i++) {
            if (i + 1 >= prices.length) return res;
            if (prices[i+1] > prices[i]) res += prices[i+1] - prices[i];
        }
        return res;
    }
}