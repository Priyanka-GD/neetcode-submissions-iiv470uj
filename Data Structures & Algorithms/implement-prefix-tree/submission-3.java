class PrefixTree {
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new Trie());        
            }
            node = node.children.get(ch);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        Trie trie = containsString(word);
        return trie != null && trie.wordEnd;
    }

    public boolean startsWith(String prefix) {
        return containsString(prefix) != null;
    }

    public Trie containsString(String word){
        Trie node = root;
        for(char ch : word.toCharArray()){
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
            }else{
                return null;
            }
        }
        return node;
    }
}
class Trie{
    Map<Character, Trie> children = new HashMap<>();
    boolean wordEnd = false;
}
