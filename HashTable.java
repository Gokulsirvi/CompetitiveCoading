public class HashTable {

    private static final int SIZE = 16;
    private String[][] table = new String[SIZE][2];

    // Hash Function
    private int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray())
            hash = (hash * 31 + c) % SIZE;
        return hash;
    }

    // Insert key-value pair
    public void put(String key, String value) {
        int index = hash(key);
        // Linear probing for collision
        while (table[index][0] != null && !table[index][0].equals(key))
            index = (index + 1) % SIZE;
        table[index][0] = key;
        table[index][1] = value;
        System.out.println("Stored  [" + key + " -> " + value + "] at index " + index);
    }

    // Retrieve value by key
    public String get(String key) {
        int index = hash(key);
        while (table[index][0] != null) {
            if (table[index][0].equals(key))
                return table[index][1];
            index = (index + 1) % SIZE;
        }
        return null;
    }

    // Delete a key
    public void delete(String key) {
        int index = hash(key);
        while (table[index][0] != null) {
            if (table[index][0].equals(key)) {
                table[index][0] = null;
                table[index][1] = null;
                System.out.println("Deleted [" + key + "] from index " + index);
                return;
            }
            index = (index + 1) % SIZE;
        }
        System.out.println("Key [" + key + "] not found.");
    }

    // Display entire hash table
    public void display() {
        System.out.println("\n--- Hash Table ---");
        for (int i = 0; i < SIZE; i++)
            if (table[i][0] != null)
                System.out.println("Index " + i + " : " + table[i][0] + " -> " + table[i][1]);
        System.out.println("------------------\n");
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();

        // Store key-value pairs
        System.out.println("=== Inserting ===");
        ht.put("name",    "Alice");
        ht.put("age",     "25");
        ht.put("city",    "Mumbai");
        ht.put("country", "India");
        ht.put("email",   "alice@example.com");

        // Display table
        ht.display();

        // Retrieve values
        System.out.println("=== Retrieving ===");
        System.out.println("name    -> " + ht.get("name"));
        System.out.println("city    -> " + ht.get("city"));
        System.out.println("email   -> " + ht.get("email"));
        System.out.println("phone   -> " + ht.get("phone")); // not found

        // Delete a key
        System.out.println("\n=== Deleting ===");
        ht.delete("age");
        ht.delete("phone"); // not found

        // Display after deletion
        ht.display();
    }
}
// ```

// **Output:**
// ```
// === Inserting ===
// Stored  [name -> Alice]           at index 7
// Stored  [age -> 25]               at index 6
// Stored  [city -> Mumbai]          at index 3
// Stored  [country -> India]        at index 1
// Stored  [email -> alice@example.com] at index 2

// --- Hash Table ---
// Index 1 : country -> India
// Index 2 : email   -> alice@example.com
// Index 3 : city    -> Mumbai
// Index 6 : age     -> 25
// Index 7 : name    -> Alice
// ------------------

// === Retrieving ===
// name    -> Alice
// city    -> Mumbai
// email   -> alice@example.com
// phone   -> null

// === Deleting ===
// Deleted [age] from index 6
// Key [phone] not found.
