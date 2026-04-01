class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;

        int maxProduct = Integer.MIN_VALUE;

        for(int num : nums){
            if(product == 0)
                product = 1;
            product *= num;
            maxProduct = Math.max(maxProduct, product);
        }
        product = 1;
        for(int idx = nums.length - 1; idx >= 0; idx--){
            if(product == 0)
                product = 1;
            product *= nums[idx];
            maxProduct = Math.max(maxProduct, product);
        }

        return maxProduct;
    }
}
