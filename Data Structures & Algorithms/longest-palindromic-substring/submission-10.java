class Solution {
    public String longestPalindrome(String s) {
        // "ababd"
        if (s == null || s.length() == 0)
            return null;
        if (s.length() == 1)
            return s;
        int maxLen = 1;
        String answer = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int diff = 2; i + diff <= s.length(); diff++) {
                String subStr = s.substring(i, i + diff);
                if (isPalindrome(subStr)) {
                    if(maxLen < diff){
                        maxLen = diff;
                        answer = subStr;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPalindrome(String str) {
        int midIdx = str.length() / 2;
        for (int startIdx = 0, endIdx = str.length() - 1; 
            startIdx < midIdx; startIdx++, endIdx--) {
            if (str.charAt(startIdx) != str.charAt(endIdx))
                return false;
        }
        return true;
    }
}
