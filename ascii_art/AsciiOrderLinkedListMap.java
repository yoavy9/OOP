package ascii_art;

import java.util.HashMap;

public class AsciiOrderLinkedListMap {
    private HashMap<Double, AsciiOrderLinkedList> map;
    private double maxBrightness = 0;
    private double minBrightness = 1;

    public AsciiOrderLinkedListMap() {
        this.map = new HashMap<>();
    }

    // Method to insert a character into the AsciiOrderLinkedList associated with the given key
    public void addChar(double key, char value) {
        // Check if the map already contains a list for the given key
        AsciiOrderLinkedList list = map.computeIfAbsent(key, k -> new AsciiOrderLinkedList());

        // Insert the character into the list in ASCII order
        list.insertInOrder(value);

        // check if the key is the max or min brightness
        if (key > maxBrightness) {
            maxBrightness = key;
        }
        if (key < minBrightness) {
            minBrightness = key;
        }
    }

    // Method to get the first character in the list associated with the given key
    public Character getChar(double key) {
        double closestKey = calculateClosestKey(key);
        return map.get(closestKey).getFirst();
    }

    public void removeChar(char c){
        for (double k : map.keySet()) {
            AsciiOrderLinkedList list = map.get(k);
            if (list.contains(c)) {
                list.remove(c);
            }
        }
    }

    public double getMaxBrightness() {
        return maxBrightness;
    }

    public double getMinBrightness() {
        return minBrightness;
    }



    private double calculateClosestKey(double key) {
        double closestKey = 0;
        double minDifference = Double.MAX_VALUE;
        for (double k : map.keySet()) {
            double difference = Math.abs(k - key);
            if (difference < minDifference) {
                minDifference = difference;
                closestKey = k;
            }
        }
        return closestKey;
    }

    // todo: remove printer
    public void printList(double key) {
        // print all keys
        for (double k : map.keySet()) {
            System.out.println("Key: " + k);
        }

        double closestKey = calculateClosestKey(key);
        System.out.println("Closest key: " + closestKey);
        AsciiOrderLinkedList list = map.get(closestKey);
        if (list != null) {
            list.printList();
        }
    }
}
