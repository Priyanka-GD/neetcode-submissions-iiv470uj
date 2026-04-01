class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int idx1 = 0; idx1 < nums.length; idx1++) {
            int product = 1;
            for (int idx2 = idx1; idx2 < nums.length; idx2++) {
                product *= nums[idx2];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
}
