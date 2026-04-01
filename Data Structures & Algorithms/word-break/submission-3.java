class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class Solution {
    private TrieNode root = new TrieNode();

    // Helper to build the Trie
    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) curr.children[i] = new TrieNode();
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 1. Build the Trie - O(m * k)
        for (String word : wordDict) {
            insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // Base case

        // 2. DP working backwards
        for (int i = n - 1; i >= 0; i--) {
            TrieNode curr = root;
            // Instead of looping through wordDict, walk down the Trie
            for (int j = i; j < n; j++) {
                int charIdx = s.charAt(j) - 'a';
                if (curr.children[charIdx] == null) break; // Optimization: No prefix matches
                
                curr = curr.children[charIdx];
                if (curr.isEndOfWord) {
                    // If we found a word, current index is true if 
                    // the state after this word is true
                    if (dp[j + 1]) {
                        dp[i] = true;
                        break; 
                    }
                }
            }
        }

        return dp[0];
    }
}