class Solution {  
    TrieNode root = new TrieNode(); ;
    public String longestCommonPrefix(String[] strs) {
        for(String str : strs){
            addWord(str);
        }        
        return getLongestCommonPrefix(root);
    }

    public String getLongestCommonPrefix(TrieNode root) {
        StringBuilder res = new StringBuilder();
        TrieNode curr = root;
                while (curr.children.size() == 1 && !curr.isEnd) {
            for (char key : curr.children.keySet()) {
                res.append(key);
                curr = curr.children.get(key);
            }
        }
        return res.toString();
    }

    public void addWord(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
}
class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
}