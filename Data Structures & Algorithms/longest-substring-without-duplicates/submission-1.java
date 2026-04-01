class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> currentWindow = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

        while(right < s.length()){
            char rightChar = s.charAt(right);
            currentWindow.put(rightChar, 
                currentWindow.getOrDefault(rightChar, 0) + 1);
            while(currentWindow.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                currentWindow.put(leftChar, 
                    currentWindow.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
