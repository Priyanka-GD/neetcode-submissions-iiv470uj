class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;

        for(int row = 0; row < len; row++){
            dp[row][row] = true;
            count++;
        }

        for(int row = 0; row < len - 1; row++){
            if(s.charAt(row) == s.charAt(row + 1)){
                dp[row][row + 1] = true;
                count++;
            }
        }

        for(int diff = 2; diff < len; diff++){
            for(int idx = 0; idx < len - diff; idx++){
                int nextIdx = diff + idx;
                if(s.charAt(idx) == s.charAt(nextIdx) &&
                    dp[idx + 1][nextIdx - 1]){
                        dp[idx][nextIdx] = true;
                        count++;
                }
            }
        }
        return count;
    }
}
