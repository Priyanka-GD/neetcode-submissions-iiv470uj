class Solution {
    public int firstMissingPositive(int[] nums) {
        int maxNum = 0;
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }
        int count[] = new int[maxNum + 1];
        for(int num : nums){
            if(num > 0)
                count[num]++;
        }
        for(int idx = 1; idx <= maxNum; idx++){
            if(count[idx] == 0)
                return idx;
        }
        return maxNum + 1;
    }
}