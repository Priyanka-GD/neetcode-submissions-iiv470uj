class Solution {
    Trie root = new Trie();

    public String longestCommonPrefix(String[] strs) {
        for (String str : strs) {
            if (str.isEmpty()) {
                return "";
            }
            addWord(str);
        }
        StringBuilder sb = new StringBuilder();
        getSubStr(root, sb);
        return sb.toString();
    }

    public void addWord(String str) {
        Trie node = root;
        for (char ch : str.toCharArray()) {
            node.children.putIfAbsent(ch, new Trie());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public void getSubStr(Trie node, StringBuilder str) {
        if (node.children.keySet().size() == 1 && !node.isEnd) {
            for (char ch : node.children.keySet()) {
                str.append(ch);
                node = node.children.get(ch);
                getSubStr(node, str);
            }
        } else {
            return;
        }
    }
}

class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean isEnd = false;
}