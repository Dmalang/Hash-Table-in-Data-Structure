import java.util.LinkedList;

public class SimpleHash {
    private LinkedList<Integer>[] table;

    @SuppressWarnings("unchecked")
    public SimpleHash(int size) {
        // Initialize the table with LinkedLists
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(int key) {
        int index = key % table.length;
        table[index].add(key);
    }

    public int search(int key) {
        int index = key % table.length;
        LinkedList<Integer> bucket = table[index];

        // Check if the key exists in the bucket
        if (bucket.contains(key)) {
            return index; // Return the index where the key is found
        }

        return -1; // Key not found
    }

    public void display() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        SimpleHash hashTable = new SimpleHash(10);

        // Insert some keys
        hashTable.insert(12);
        hashTable.insert(22);
        hashTable.insert(32);
        hashTable.insert(15);
        hashTable.insert(25);

        // Display the hash table
        hashTable.display();

        // Search for keys
        int keyToSearch1 = 22;
        int keyToSearch2 = 40;

        System.out.println("Key " + keyToSearch1 + " found at index: " + hashTable.search(keyToSearch1));
        System.out.println("Key " + keyToSearch2 + " found at index: " + hashTable.search(keyToSearch2));
    }
}
