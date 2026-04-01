class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums)
            numSet.add(num);
        int maxSeqLen = 0;
        for(int num : numSet){
            int currNum = num;
            int longestSubLen = 1;

            while(numSet.contains(currNum + 1)){
                longestSubLen++;
                currNum += 1;
            }
            maxSeqLen = Math.max(maxSeqLen, longestSubLen);
        }
        return maxSeqLen;
    }
}
