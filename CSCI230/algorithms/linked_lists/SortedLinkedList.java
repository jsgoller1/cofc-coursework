package algorithms.linked_lists;

public class SortedLinkedList extends LinkedList {
    @Override
    public void insert(int value) {
        LinkedListNode newNode = new LinkedListNode(value, null);
        // Case: insert into empty list
        if (head == tail && head == null) {
            head = tail = newNode;
            return;
        }

        // Case: insert new minimum element (i.e. new head)
        if (value < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Case: new node is not minimum
        LinkedListNode curr = head;
        while (curr.next != null && curr.next.data < value) {
            curr = curr.next;
        }
        // Subcase: new node is maximum element (i.e. new tail)
        if (curr.next == null) {
            curr.next = newNode;
            tail = newNode;
            return;
        }
        // Subcase: new node is not min or max element
        newNode.next = curr.next;
        curr.next = newNode;
    }

}
