package av3.tadhash.questao1256;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int tableSize = scanner.nextInt();
            int numberOfKeys = scanner.nextInt();

            HashTable hashTable = new HashTable(tableSize);

            for (int i = 0; i < numberOfKeys; i++) {
                int key = scanner.nextInt();
                hashTable.insert(key);
            }

            hashTable.display();

            if (t < testCases - 1) {
                System.out.println();
            }
        }
        scanner.close();
    }

    private static class HashTable {
        private final LinkedList[] TABLE;
        private final int SIZE;

        public HashTable(int SIZE) {
            this.SIZE = SIZE;
            TABLE = new LinkedList[SIZE];

            for (int i = 0; i < SIZE; i++) {
                TABLE[i] = new LinkedList();
            }
        }

        private int hash(int value) {
            return value % SIZE;
        }

        public void insert(int value) {
            int index = hash(value);
            TABLE[index].add(value);
        }

        public void display() {
            for (int i = 0; i < SIZE; i++) {
                System.out.println(i + " -> " + TABLE[i].toString());
            }
        }
    }

    private static class LinkedList {
        private static class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

        private Node head;

        public LinkedList() {
            this.head = null;
        }

        public void add(int value) {
            if (head == null) {
                head = new Node(value);
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(value);
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node current = head;

            while (current != null) {
                result.append(current.value).append(" -> ");
                current = current.next;
            }

            result.append("\\");
            return result.toString();
        }
    }
}
