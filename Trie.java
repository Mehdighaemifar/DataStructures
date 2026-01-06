class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode();

            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    // Search for a word
    public boolean search(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }
        return curr.isEndOfWord;
    }

    // Check if a node has no children
    private boolean isEmptyNode(TrieNode node) {
        for (int i = 0; i < 26; i++)
            if (node.children[i] != null)
                return false;
        return true;
    }

    // Public isEmpty: checks if the whole trie is empty
    public boolean isEmpty() {
        return isEmptyNode(root);
    }

    // Recursive delete helper
    private boolean deleteHelper(TrieNode curr, String word, int depth) {
        if (curr == null) return false;

        if (depth == word.length()) {
            if (!curr.isEndOfWord) return false;

            curr.isEndOfWord = false;
            return isEmptyNode(curr);
        }

        int idx = word.charAt(depth) - 'a';

        if (deleteHelper(curr.children[idx], word, depth + 1)) {
            curr.children[idx] = null;
            return !curr.isEndOfWord && isEmptyNode(curr);
        }

        return false;
    }

    // Remove a word
    public void remove(String word) {
        deleteHelper(root, word, 0);
    }
}

class Main3 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("tree");
        trie.insert("trie");
        trie.insert("algo");
        trie.insert("assoc");

        System.out.println(trie.search("tree"));   // true
        System.out.println(trie.search("trie"));   // true
        System.out.println(trie.search("alg"));    // false

        trie.remove("tree");
        System.out.println(trie.search("tree"));   // false
        System.out.println(trie.search("trie"));   // true

        trie.remove("trie");
        trie.remove("algo");
        trie.remove("assoc");

        System.out.println(trie.isEmpty());        // true
    }
}
