import java.util.HashSet;

public class DistinctSubstrings {

    public static void findDistinctSubstrings(String s) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j <= s.length(); j++)
                set.add(s.substring(i, j));

        System.out.println("String: \"" + s + "\"");
        System.out.println("Distinct Substrings: " + set);
        System.out.println("Total Count: " + set.size());
    }

    public static void main(String[] args) {
        findDistinctSubstrings("abc");
        System.out.println();
        findDistinctSubstrings("aab");
        System.out.println();
        findDistinctSubstrings("abcd");
    }
}
// ```

// **Output:**
// ```
// String: "abc"
// Distinct Substrings: [a, b, c, ab, bc, abc]
// Total Count: 6

// String: "aab"
// Distinct Substrings: [a, b, ab, aab, aa]
// Total Count: 5

// String: "abcd"
// Distinct Substrings: [a, b, c, d, ab, bc, cd, abc, bcd, abcd]
// Total Count: 10
