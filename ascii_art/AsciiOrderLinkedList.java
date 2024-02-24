package ascii_art;

import java.util.LinkedList;
import java.util.ListIterator;

public class AsciiOrderLinkedList {
    private LinkedList<Character> list;


    public AsciiOrderLinkedList() {
        this.list = new LinkedList<>();
    }

    // Method to insert a character in ASCII order
    public void insertInOrder(char value) {
        ListIterator<Character> iterator = list.listIterator();

        // Find the correct position for insertion
        while (iterator.hasNext()) {
            if (iterator.next() > value) {
                // Previous moves the cursor back to the element just returned by next()
                iterator.previous();
                break;
            }
        }
        // Insert the character at the found position
        iterator.add(value);
    }

    public boolean contains(char c){
        return list.contains(c);
    }

    public void remove(char c){
        list.remove(c);
    }

    // todo: remove printer
    public void printList() {
        for (Character c : list) {
            System.out.print(c);
        }
    }

    public Character getFirst() {
        return list.getFirst();
    }

    // Method to print the list
    public AsciiOrderLinkedList getAsciiorderList() {
        return this;
    }
}