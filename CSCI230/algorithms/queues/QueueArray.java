package algorithms.queues;

public class QueueArray {
    String[] data;
    int head = 0;
    int tail = 0;

    public QueueArray(int size) {
        data = new String[size];
    }

    public void enqueue(String value) {
        // Queue full, copy and resize
        if ((tail + 1) % data.length == head) {
            String[] newData = new String[data.length * 2];
            int curr = head;
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[curr];
                curr = (curr + 1) % data.length;
            }
            tail = data.length - 1;
            head = 0;
            data = newData;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
    }

    public String dequeue() {
        if (head == tail) {
            System.out.println("Queue empty.");
            return null;
        }
        String item = data[head];
        // Not strictly necessary, but makes print debugging easier
        data[head] = null;
        head = (head + 1) % data.length;
        return item;
    }

    public String peek() {
        if (head != tail) {
            return data[head];
        }
        return null;
    }

    public void print() {
        System.out.printf("Head: %d\n", head);
        System.out.printf("Tail: %d\n", tail);

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d: %s\n", i, data[i]);
        }
        System.out.println("------");
    }

    public void reverse() {
        if (head == tail) {
            return;
        }
        String text = this.dequeue();
        reverse();
        this.enqueue(text);
    }
}
