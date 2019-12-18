package data_structures.hash_tables;

import java.util.LinkedList;
import java.util.Scanner;

public class A_hashing {

    static final int SIZE = 1000000;
    static LinkedList<String>[] hashTable =  new LinkedList[SIZE];

    static int hashCode(String value) {
        return Math.abs(value.hashCode()) % SIZE;
    }

    static void add(String value) {
        int hash = hashCode(value);
        if (hashTable[hash] == null) {
            hashTable[hash] = new LinkedList<>();
        }
        if (!hashTable[hash].contains(value)) {
            hashTable[hash].addLast(value);
        }
    }

    static boolean contains(String value) {
        int hash = hashCode(value);
        if (hashTable[hash] == null) {
            return false;
        }
        return hashTable[hash].contains(value);
    }

    static void delete(String value) {
        int hash = hashCode(value);
        if (hashTable[hash] == null) {
            return;
        }
        hashTable[hash].remove(value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        StringBuilder res = new StringBuilder();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if ("#".equals(line)) {
                break;
            }

            String[] commands = line.split(" ");
            switch (commands[0]) {
                case "+":
                    add(commands[1]);
                    break;
                case "?":
                    res.append((contains(commands[1]) ? "YES" : "NO") + "\n");
                    //System.out.println(contains(commands[1]) ? "YES" : "NO");
                    break;
                case "-":
                    delete(commands[1]);
                    break;
            }
        }
        System.out.println(res.toString());
    }
}
