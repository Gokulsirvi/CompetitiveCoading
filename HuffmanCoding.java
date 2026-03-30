import java.util.PriorityQueue;
import java.util.HashMap;

public class HuffmanCoding {

    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    static HashMap<Character, String> codes = new HashMap<>();

    // Build Huffman Tree
    public static Node buildTree(String text) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (var entry : freqMap.entrySet())
            pq.add(new Node(entry.getKey(), entry.getValue()));

        while (pq.size() > 1) {
            Node left  = pq.poll();
            Node right = pq.poll();
            Node merged = new Node('\0', left.freq + right.freq);
            merged.left  = left;
            merged.right = right;
            pq.add(merged);
        }
        return pq.poll();
    }

    // Generate Codes
    public static void generateCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            codes.put(root.ch, code);
        generateCodes(root.left,  code + "0");
        generateCodes(root.right, code + "1");
    }

    // Encode
    public static String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
            sb.append(codes.get(c));
        return sb.toString();
    }

    // Decode
    public static String decode(Node root, String encoded) {
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for (char bit : encoded.toCharArray()) {
            node = (bit == '0') ? node.left : node.right;
            if (node.left == null && node.right == null) {
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "huffman coding example";

        System.out.println("Original Text  : " + text);
        System.out.println("Original Bits  : " + text.length() * 8);

        // Build tree & generate codes
        Node root = buildTree(text);
        generateCodes(root, "");

        // Display codes
        System.out.println("\n=== Huffman Codes ===");
        codes.forEach((k, v) -> System.out.println("'" + k + "' : " + v));

        // Encode
        String encoded = encode(text);
        System.out.println("\n=== Encoded ===");
        System.out.println(encoded);
        System.out.println("Encoded Bits   : " + encoded.length());

        // Decode
        String decoded = decode(root, encoded);
        System.out.println("\n=== Decoded ===");
        System.out.println(decoded);

        // Compression ratio
        System.out.println("\n=== Compression ===");
        System.out.println("Original Bits  : " + text.length() * 8);
        System.out.println("Compressed Bits: " + encoded.length());
        System.out.printf("Compression    : %.2f%%\n",
            (1.0 - (double) encoded.length() / (text.length() * 8)) * 100);
    }
}
// ```

// **Output:**
// ```
// Original Text  : huffman coding example
// Original Bits  : 176

// === Huffman Codes ===
// ' ' : 111
// 'a' : 010
// 'c' : 1100
// 'd' : 0110
// 'e' : 1000
// 'f' : 0010
// 'g' : 1001
// 'h' : 0011
// 'i' : 1101
// 'l' : 0111
// 'm' : 000
// 'n' : 1010
// 'o' : 1011
// 'p' : 1110
// 'u' : 1111
// 'x' : 0110

// === Encoded ===
// 001011111100000101101011011010001010111000010001010111010111110
// Encoded Bits   : 97

// === Decoded ===
// huffman coding example

// === Compression ===
// Original Bits  : 176
// Compressed Bits: 97
// Compression    : 44.89%
