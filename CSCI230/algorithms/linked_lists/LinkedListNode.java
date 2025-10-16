package algorithms.linked_lists;

public class LinkedListNode {
    public int data;
    public LinkedListNode next = null;

    LinkedListNode(int nodeData, LinkedListNode node) {
        next = node;
        data = nodeData;
    }
}
