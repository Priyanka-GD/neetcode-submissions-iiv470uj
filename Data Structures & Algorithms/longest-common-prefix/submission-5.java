class Solution {  
    TrieNode root = new TrieNode(); ;
    public String longestCommonPrefix(String[] strs) {
        for(String str : strs){
            addWord(str);
        }
        StringBuilder res  = new StringBuilder();
        getLongestCommonPrefix(root, res);
        return res.toString();
    }

    public void getLongestCommonPrefix(TrieNode node, StringBuilder res){
        if(node.isEnd){
            return;
        }
        if(node.children.size() == 1){
            for(char key : node.children.keySet()){
                res.append(key);
                node = node.children.get(key);
                getLongestCommonPrefix(node, res);
            }
        }
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