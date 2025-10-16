package lab_5_sorted_number_list;


/*
 * Cases: - Empty list: added val always becomes head/tail, removals fail - Add new head: - Add new
 * tail: - Delete old head: - Delete old tail:
 */


public class SortedNumberList {
    public Node head;
    public Node tail;

    public SortedNumberList() {
        head = null;
        tail = null;
    }

    // Optional: Add any desired private methods here


    // Inserts the number into the list in the correct position such that the
    // list remains sorted in ascending order.
    public void insert(double number) {
        Node newNode = new Node(number);

        // Edge cases: empty list, or new node becomes new head
        if (head == null || newNode.data <= head.data) {
            tail = (head == null) ? newNode : tail;
            newNode.next = head;
            head = newNode;
            return;
        }

        // Search for spot where curr.data <= number <= curr.next.data
        Node curr = head;
        while (curr.next != null && curr.data <= number && curr.next.data <= number) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        // Fix up tail if we added to the end of the list
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // Removes the node with the specified number value from the list. Returns
    // true if the node is found and removed, false otherwise.
    public boolean remove(double number) {
        // Edge case: empty list, do nothing.
        if (head == null) {
            return false;
        }

        Node curr = head;
        // Edge case: remove head. If head was only element in list, also fix tail if list
        // now empty
        if (number == head.data) {
            head = head.next;
            tail = (head == null) ? null : tail;
            return true;
        }

        // Find number to remove
        while (curr.next != null && curr.next.data != number) {
            curr = curr.next;
        }
        // Delete the node, fix up tail
        if (curr.next != null) {
            curr.next = curr.next.next;
            tail = (curr.next == null) ? curr : tail;
            return true;
        }

        return false;
    }
}
