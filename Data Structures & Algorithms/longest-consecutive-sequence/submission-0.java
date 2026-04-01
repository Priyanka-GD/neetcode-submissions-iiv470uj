class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums)
            seen.add(num);
        int longestSeq = 0;
        
        for(int num : nums)
        {
            int currNum = num;
            int currentSeq = 1;
            while(seen.contains(currNum + 1))
            {
                currentSeq++;
                currNum++;
            }
            longestSeq = Math.max(longestSeq, currentSeq);
        }
        return longestSeq;
    }
}
