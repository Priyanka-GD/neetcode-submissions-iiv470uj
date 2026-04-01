class Solution {
    public int numDecodings(String s) {
        return recursionDecodeStr(0, s);
    }

    private int recursionDecodeStr(int idx, String str) {
        if (idx == str.length())
            return 1;
        if (str.charAt(idx) == '0')
            return 0;
        int ans = recursionDecodeStr(idx + 1, str);
        if (idx + 1 < str.length() && Integer.parseInt(str.substring(idx, idx + 2)) <= 26)
            ans += recursionDecodeStr(idx + 2, str);
        return ans;
    }
}