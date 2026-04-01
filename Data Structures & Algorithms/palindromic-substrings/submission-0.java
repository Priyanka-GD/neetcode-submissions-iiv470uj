class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
                return 0;
            if (s.length() == 1)
                return 1;
            int count = s.length();
            for (int i = 0; i < s.length(); i++) {
                for (int diff = 2; i + diff <= s.length(); diff++) {
                    String subStr = s.substring(i, i + diff);
                    if (isPalindrome(subStr)) 
                        count++;
                    }
            }
            return count;
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

