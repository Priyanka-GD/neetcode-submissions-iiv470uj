class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMapWithFreq = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            charMapWithFreq.put(rightChar, charMapWithFreq.getOrDefault(rightChar, 0) + 1);

            while(charMapWithFreq.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                charMapWithFreq.put(leftChar, charMapWithFreq.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
