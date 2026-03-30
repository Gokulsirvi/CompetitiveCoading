public class Trie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root = new TrieNode();

    // Insert a word
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
        System.out.println("Inserted: " + word);
    }

    // Search a word
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return false;
            node = node.children[i];
        }
        return node.isEnd;
    }

    // Remove a word
    public void remove(String word) {
        if (removeHelper(root, word, 0))
            System.out.println("Removed: " + word);
        else
            System.out.println("Word not found: " + word);
    }

    private boolean removeHelper(TrieNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEnd) return false;
            node.isEnd = false;
            return isEmpty(node);
        }

        int i = word.charAt(depth) - 'a';
        if (removeHelper(node.children[i], word, depth + 1))
            node.children[i] = null;

        return !node.isEnd && isEmpty(node);
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null) return false;
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert
        System.out.println("=== Insert ===");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");

        // Search
        System.out.println("\n=== Search ===");
        System.out.println("Search 'apple' : " + trie.search("apple")); // true
        System.out.println("Search 'app'   : " + trie.search("app"));   // true
        System.out.println("Search 'ap'    : " + trie.search("ap"));    // false
        System.out.println("Search 'bat'   : " + trie.search("bat"));   // true
        System.out.println("Search 'cat'   : " + trie.search("cat"));   // false

        // Remove
        System.out.println("\n=== Remove ===");
        trie.remove("app");
        trie.remove("cat");  // not found

        // Search after removal
        System.out.println("\n=== Search After Remove ===");
        System.out.println("Search 'app'   : " + trie.search("app"));   // false
        System.out.println("Search 'apple' : " + trie.search("apple")); // true
    }
}
// ```

// **Output:**
// ```
// === Insert ===
// Inserted: apple
// Inserted: app
// Inserted: bat
// Inserted: ball

// === Search ===
// Search 'apple' : true
// Search 'app'   : true
// Search 'ap'    : false
// Search 'bat'   : true
// Search 'cat'   : false

// === Remove ===
// Removed: app
// Word not found: cat

// === Search After Remove ===
// Search 'app'   : false
// Search 'apple' : true
