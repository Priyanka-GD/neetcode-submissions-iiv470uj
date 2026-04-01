class Solution {
    public int maxProduct(int[] nums) {
        int product = 1, maxProduct = Integer.MIN_VALUE;
        for (int idx = 0; idx < nums.length; idx++) {
            if (product == 0)
                product = 1;
            product *= nums[idx];
            maxProduct = Math.max(product, maxProduct);
        }
        product = 1;
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            if (product == 0)
                product = 1;
            product *= nums[idx];
            maxProduct = Math.max(product, maxProduct);
        }
        return maxProduct;
    }
}