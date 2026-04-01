class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchInNodes(word, root);
    }

    public boolean searchInNodes(String word, TrieNode root) {
        TrieNode node = root;
        for (int idx = 0; idx < word.length(); idx++) {
            char ch = word.charAt(idx);
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                if (ch == '.') {
                    for (char key : node.children.keySet()) {
                        TrieNode child = node.children.get(key);
                        String searchWord = word.substring(idx + 1);
                        if (searchInNodes(searchWord, child))
                            return true;
                    }
                }
                return false;
            }
        }
        return node.isEnd;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;

    public TrieNode() {
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */