class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums)
            seen.add(num);
        int longestSeq = 0;

        for (int num : seen) {
            if (!seen.contains(num - 1)) {
                int currNum = num;
                int currentSeq = 1;
                while (seen.contains(currNum + 1)) {
                    currNum = currNum + 1;
                    currentSeq += 1;

                }
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }
        return longestSeq;
    }
}
