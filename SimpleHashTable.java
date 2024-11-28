import java.util.LinkedList;

public class SimpleHashTable {
    private LinkedList<Integer>[] table;

    @SuppressWarnings("unchecked")
    public SimpleHashTable(int size) {
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

    public void display() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        SimpleHashTable hashTable = new SimpleHashTable(10);
        hashTable.insert(12);
        hashTable.insert(22);
        hashTable.insert(32);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.display();
    }
}
