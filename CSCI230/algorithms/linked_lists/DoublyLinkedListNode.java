package algorithms.linked_lists;

public class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    DoublyLinkedListNode(int nodeData, DoublyLinkedListNode nextNode,
            DoublyLinkedListNode prevNode) {
        data = nodeData;
        next = nextNode;
        prev = prevNode;
    };


}
