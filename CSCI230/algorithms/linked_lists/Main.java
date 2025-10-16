package algorithms.linked_lists;

public class Main {
    public static void linkedListTest() {
        LinkedList ll = new LinkedList();
        // Basic setup
        ll.insert((10));
        ll.insert((20));
        ll.insert((30));
        ll.print();
        // Test: delete middle
        ll.delete(20);
        ll.print();
        ll.insert((40));
        ll.print();
        // Delete head
        ll.delete(10);
        ll.print();
        // Delete tail
        ll.delete(40);
        ll.print();
    }

    public static void sortedLinkedListTest() {
        LinkedList ll = new SortedLinkedList();
        // Basic setup
        ll.insert((50));
        ll.insert((20));
        ll.insert((70));
        ll.print();
        // Test: delete middle, then insert new middle
        ll.delete(50);
        ll.print();
        ll.insert((40));
        ll.print();
        // Delete head
        ll.delete(20);
        ll.print();
        // Delete tail
        ll.delete(70);
        ll.print();
    }

    public static void doublyLinkedListTest() {
        DoublyLinkedList ll = new DoublyLinkedList();
        // Basic setup
        ll.insert((50));
        ll.insert((20));
        ll.insert((70));
        ll.print();
        // Test: delete head, then insert new tail
        ll.delete(50);
        ll.print();
        ll.insert((40));
        ll.print();
        // Delete head
        ll.delete(20);
        ll.print();
        // Delete tail
        ll.delete(40);
        ll.print();
    }

    public static void main(String[] args) {
        doublyLinkedListTest();
    }
}
