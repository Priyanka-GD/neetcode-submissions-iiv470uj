class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mapOfCharWithFreq = new HashMap<>();
        int right = 0, left = 0, maxLength = 0;

        while(right < s.length()){
            char rightChar = s.charAt(right);
            mapOfCharWithFreq.put(rightChar, mapOfCharWithFreq.getOrDefault(rightChar, 0) + 1);

            while(mapOfCharWithFreq.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                mapOfCharWithFreq.put(leftChar, mapOfCharWithFreq.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
