package algorithms.queues;

import java.util.Queue;
import algorithms.queues.QueueArray;

public class Main {
    public static void queueTest() {
        QueueArray queue = new QueueArray(4);
        queue.enqueue("One");
        queue.print();
        queue.enqueue("Two");
        queue.print();
        queue.enqueue("Three");
        queue.dequeue();
        queue.print();
        queue.enqueue("Four");
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }

    public static void queueReverseRecursive() {
        QueueArray queue = new QueueArray(10);
        for (int i = 0; i < 9; i++) {
            queue.enqueue(Integer.toString(i * 100));
        }
        queue.print();
        queue.reverse();
        queue.print();
    }

    public static void main(String[] args) {
        queueReverseRecursive();
    }
}
