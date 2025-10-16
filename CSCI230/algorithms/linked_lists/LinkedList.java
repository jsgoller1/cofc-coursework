package algorithms.linked_lists;

import algorithms.linked_lists.LinkedListNode;

public class LinkedList {
    public LinkedListNode head = null;
    public LinkedListNode tail = null;

    public void insert(int value) {
        LinkedListNode newNode = new LinkedListNode(value, null);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public LinkedListNode search(int value) {
        LinkedListNode curr = head;
        while (curr != null && curr.data != value) {
            curr = curr.next;
        }
        return curr;
    }

    public void delete(int value) {
        // Case: list empty
        if (head == null && tail == null) {
            return;
        }
        // Case: List contains a single element
        if (head == tail && head.data == value) {
            head = null;
            tail = null;
            return;
        }
        // Case: List contains more than 1 element
        LinkedListNode curr = head;
        // Subcase: delete head
        if (curr.data == value) {
            head = head.next;
            return;
        }
        while (curr.next != null && curr.next.data != value) {
            curr = curr.next;
        }
        // Subcase: Didn't find element to delete
        if (curr.next == null) {
            return;
        }
        // Otherwise, delete node
        curr.next = curr.next.next;
    }

    public void print() {
        LinkedListNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("----------");
    }
}
