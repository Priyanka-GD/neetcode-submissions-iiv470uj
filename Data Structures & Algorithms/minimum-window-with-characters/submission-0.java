class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray())
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);

        Map<Character, Integer> currWindowMap = new HashMap<>();
        int ans[] = new int[] { 0, 0, -1 };
        int left = 0, right = 0;
        int formed = 0;
        int required = tMap.size();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            currWindowMap.put(rightChar, currWindowMap.getOrDefault(rightChar, 0) + 1);

            if (tMap.containsKey(rightChar)
                    && currWindowMap.get(rightChar).intValue() == tMap.get(rightChar).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                if (ans[2] == -1 || right - left + 1 < ans[2]) {
                    ans[0] = left;
                    ans[1] = right;
                    ans[2] = right - left + 1;
                }
                char leftChar = s.charAt(left);
                currWindowMap.put(leftChar, currWindowMap.get(leftChar) - 1);
                left++;

                if (tMap.containsKey(leftChar)
                        && currWindowMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    formed--;
                }

            }
            right++;
        }
        return ans[2] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}
