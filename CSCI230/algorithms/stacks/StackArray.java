package algorithms.stacks;

import java.util.ArrayList;

class StackArray {
    private ArrayList<String> data;

    public StackArray() {
        data = new ArrayList<String>();
    }

    public void print() {
        System.out.println(data);
        System.out.println("------");
    }

    public void Stack() {
        data = new ArrayList<String>();
    }

    void push(String value) {
        data.add(value);
    }

    String pop() {
        if (data.size() == 0) {
            throw new RuntimeException("Cannot pop from empty list!");
        }
        String item = this.data.get(data.size() - 1);
        this.data.remove(data.size() - 1);
        return item;
    }

    String peek() {
        if (data.size() == 0) {
            return null;
        }
        return data.get(data.size() - 1);
    }
}
