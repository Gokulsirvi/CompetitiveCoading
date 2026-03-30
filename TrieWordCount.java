public class TrieWordCount {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root = new TrieNode();

    // Insert word
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    // Count total words
    public int countWords(TrieNode node) {
        if (node == null) return 0;
        int count = node.isEnd ? 1 : 0;
        for (TrieNode child : node.children)
            count += countWords(child);
        return count;
    }

    public static void main(String[] args) {
        TrieWordCount trie = new TrieWordCount();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("cat");

        System.out.println("Words Inserted : apple, app, bat, ball, cat");
        System.out.println("Total Words    : " + trie.countWords(trie.root)); // 5

        // Insert duplicate
        trie.insert("app");
        System.out.println("\nAfter inserting 'app' again:");
        System.out.println("Total Words    : " + trie.countWords(trie.root)); // still 5
    }
}
// ```

// **Output:**
// ```
// Words Inserted : apple, app, bat, ball, cat
// Total Words    : 5

// After inserting 'app' again:
// Total Words    : 5
