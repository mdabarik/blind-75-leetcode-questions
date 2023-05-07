class Trie {
    
    class Node {
        HashMap<Character, Node> child = new HashMap<>();
        boolean isEnd = false;
    }
    
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.child.containsKey(ch)) {
                curr.child.put(ch, new Node());
            }
            curr = curr.child.get(ch);
        }
        curr.isEnd = true;
    } // TC: O(n), SC: O(n)
    
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }
        return curr.isEnd;
    } // TC: O(n), SC: O(1)
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }
        return true;
    } // TC: O(n), SC: O(1)
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
