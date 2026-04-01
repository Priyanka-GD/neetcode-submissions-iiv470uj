class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int right = 0, left = 0, count = 0;
        while(right < s.length())
        {
            char rightChar = s.charAt(right);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            while(freq.get(rightChar) > 1)
            {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
