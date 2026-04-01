class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray())
        {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    public TrieNode checkWord(String word)
    {
        TrieNode node = root;
        for(char ch : word.toCharArray())
        {
            if(node.children.containsKey(ch))
                node = node.children.get(ch);
            else
                return null;
        }
        return node;
    }
    public boolean search(String word) {
        TrieNode node = checkWord(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = checkWord(prefix);
        return node != null;
    }
}
class TrieNode
{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
    public TrieNode(){}
}
