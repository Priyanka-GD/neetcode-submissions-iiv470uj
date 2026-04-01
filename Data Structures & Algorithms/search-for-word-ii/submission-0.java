class Solution {
    Set<String> result = new HashSet<>();
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        
        Trie root = new Trie();
        for (String word : words) {
            root.add(word);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(r, c, board, root, "");
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(int row, int col, char[][] board, Trie node, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || visited[row][col] 
            || !node.getChildren().containsKey(board[row][col])) {
            return;
        }

        char ch = board[row][col];
        Trie nextNode = node.getChildren().get(ch);
        String currentWord = word + ch;

        if (nextNode.getWordIsEnd()) {
            result.add(currentWord);
        }

        visited[row][col] = true;

        dfs(row + 1, col, board, nextNode, currentWord);
        dfs(row, col + 1, board, nextNode, currentWord);
        dfs(row - 1, col, board, nextNode, currentWord);
        dfs(row, col - 1, board, nextNode, currentWord);

        visited[row][col] = false;
    }
}

class Trie {
    private Map<Character, Trie> children;
    private boolean wordIsEnd;

    public Trie() {
        children = new HashMap<>();
        wordIsEnd = false;
    }

    public void setWordIsEnd() {
        wordIsEnd = true;
    }

    public boolean getWordIsEnd() {
        return wordIsEnd;
    }

    public Map<Character, Trie> getChildren() {
        return children;
    }
    
    public void add(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Trie());
            node = node.children.get(ch);
        }
        node.setWordIsEnd();
    }
}