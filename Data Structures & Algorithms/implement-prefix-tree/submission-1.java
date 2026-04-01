class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(char ch : word.toCharArray()){
            temp.children.putIfAbsent(ch, new Node());
            temp = temp.children.get(ch);
        }
        temp.isWordEnd = true;
    }

    public Node containsWord(String word){
        Node temp = root;
        for(char ch : word.toCharArray()){
            if(temp.children.containsKey(ch)){
                temp = temp.children.get(ch);
            }else{
                return null;
            }
        }
        return temp;
    }

    public boolean search(String word) {
        Node node = containsWord(word);
        return node == null? false : node.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = containsWord(prefix);
        return node == null? false : true;
    }
}
class Node{
    Map<Character, Node> children = new HashMap<>();
    boolean isWordEnd = false;
}
