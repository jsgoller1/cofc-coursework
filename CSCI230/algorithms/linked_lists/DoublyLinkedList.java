package algorithms.linked_lists;

public class DoublyLinkedList {
    DoublyLinkedListNode head = null;
    DoublyLinkedListNode tail = null;

    void insert(int value) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(value, null, null);
        // Case: List empty
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Case: List nonempty
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    DoublyLinkedListNode find(int value) {
        DoublyLinkedListNode curr = head;
        while (curr != null && curr.data != value) {
            curr = curr.next;
        }
        return curr;
    }

    void delete(int value) {
        DoublyLinkedListNode curr = head;
        while (curr != null && curr.data != value) {
            curr = curr.next;
        }
        // Case: item not in list
        if (curr == null) {
            return;
        }
        // Case: one item list, deleting only item
        if (head == tail && curr.data == head.data) {
            head = null;
            tail = null;
            return;
        }

        // Case: multi item list, item is head; make head next head.
        if (curr == head) {
            head = head.next;
            head.prev = null;
            return;
        }

        // Case: Multi item list, item is tail; make tail previous
        if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Case: Item found in middle; delete it.
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public void print() {
        DoublyLinkedListNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("--------");
    }
}
