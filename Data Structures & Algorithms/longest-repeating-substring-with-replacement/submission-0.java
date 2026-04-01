class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int right = 0, left = 0, count = 0, maxFreq = 0;
        while(right < s.length())
        {
            char rightChar = s.charAt(right);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(rightChar));
            int diffWindowSizeWithMaxFreq = right - left - maxFreq + 1;
            if(diffWindowSizeWithMaxFreq > k)
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
