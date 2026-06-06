class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int maxLength = 0;
        int left = 0, right = 0;
        int[] characterCount = new int[128];

        while(right < s.length()){
            char rightChar = s.charAt(right);
            characterCount[rightChar]++;

            while(characterCount[rightChar] > 1){
                char leftChar = s.charAt(left);
                characterCount[leftChar]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
