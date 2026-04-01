class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            windowFreq[rightChar - 'a']++;

            if (right - left + 1 == s1.length()) {
                if (matches(s1Freq, windowFreq)) {
                    return true;
                }
                char leftChar = s2.charAt(left);
                windowFreq[leftChar - 'a']--;
                left++;
            }
            right++;
        }
        return false;
    }

    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
