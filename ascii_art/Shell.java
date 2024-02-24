package ascii_art;

public class Shell {
    public static void main(String[] args) {
        AsciiOrderLinkedListMap map = new AsciiOrderLinkedListMap();

        // Example usage
        map.addChar(0.6, 'c');
        map.addChar(0.111, 'a');
        map.addChar(0.5, 'b');
        map.addChar(0.8, 'e');
        map.addChar(0.6, 'd');

        System.out.println("List for key 1:");
        map.printList(1); // Should print [a, b, c]
        System.out.println("\n");
        System.out.println("List for key 2:");
        map.printList(0.333); // Should print [d, e]

        System.out.println("\n");
        System.out.println("Max brightness: " + map.getMaxBrightness()); // Should print 2.0
        System.out.println("Min brightness: " + map.getMinBrightness()); // Should print 1.0

        System.out.println("Character for key 0.22: " + map.getChar(0.22)); // Should print c
        System.out.println("Character for key 0.8: " + map.getChar(0.8)); // Should print a
        }

}


