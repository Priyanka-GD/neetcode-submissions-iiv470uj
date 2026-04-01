class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans[] = new int[] { 0, 0 };

        for(int idx = 0; idx < len; idx++){
            dp[idx][idx] = true;
        }

        for(int row = 0; row < len - 1; row++){
            if(s.charAt(row) == s.charAt(row + 1)){
                dp[row][row + 1] = true;
                ans[0] = row;
                ans[1] = row + 1;
            }
        }

        for(int diff = 2; diff < len; diff++){
            for(int idx = 0; idx < len - diff; idx++){
                int nextIdx = idx + diff;
                if(s.charAt(idx) == s.charAt(nextIdx) &&
                    dp[idx + 1][nextIdx - 1]){
                        dp[idx][nextIdx] = true;
                        ans[0] = idx;
                        ans[1] = nextIdx;
                    }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
