class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Trie());
            node = node.children.get(ch);
        }
        node.wordEnd = true;
    }

    public boolean search(String word){
        Trie node = root;
        return search(word, node);
    }

    public boolean search(String word, Trie node) {
        for(int idx = 0; idx < word.length(); idx++){
            char ch = word.charAt(idx);
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
            }
            else {
                if( ch == '.'){
                    for (Trie child : node.children.values()){
                        if(search(word.substring(idx + 1), child)){
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return node.wordEnd;
    }
}
class Trie{
    Map<Character, Trie> children = new HashMap<>();
    boolean wordEnd;
}
