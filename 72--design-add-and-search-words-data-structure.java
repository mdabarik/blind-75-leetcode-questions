class WordDictionary {
    
    class Node {
        HashMap<Character, Node> child;
        boolean isEnd;
        public Node () {
            child = new HashMap<>();
            isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
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
        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int index, Node curr) {
        if (index == word.length()) return curr.isEnd;
        if (word.charAt(index) == '.') {
            for (Character ch : curr.child.keySet()) {
                if (searchWord(word, index + 1, curr.child.get(ch))) return true;
            }
            return false;
        } else {
            if (curr.child.get(word.charAt(index)) == null) return false;
            return searchWord(word, index + 1, curr.child.get(word.charAt(index)));
        }
    } // TC: O(n^2), SC: O(n)
}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
