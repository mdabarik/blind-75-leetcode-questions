class Solution {

    class Node {
        HashMap<Character, Node> child;
        String word;
        public Node() {
            child = new HashMap<>();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        Node root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;  j < board[0].length; j++) {
                dfs(board, list, root, i, j);
            }
        }
        return list;
    }

    public void dfs(char[][] board, List<String> list, Node curr, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char ch = board[i][j];

        if (ch == '#' || curr.child.get(ch) == null) return;
        curr = curr.child.get(ch);
        if (curr.word != null) {
            list.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '#';
        // top, left, down, right
        dfs(board, list, curr, i - 1, j);
        dfs(board, list, curr, i, j - 1);
        dfs(board, list, curr, i + 1, j);
        dfs(board, list, curr, i, j + 1);
        board[i][j] = ch;
    }

    public Node buildTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new Node());
                }
                curr = curr.child.get(ch);
            }
            curr.word = word;
        }
        return root;
    }
}
