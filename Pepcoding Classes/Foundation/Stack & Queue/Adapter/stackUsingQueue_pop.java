import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_pop {
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transferToAnotherStack() {
        while (this.que.size() != 0)
            this.temp.add(this.que.remove());
    }

    // O(n)
    public void push(int data) {
        transferToAnotherStack();

        this.que.add(data);
        while (this.temp.size() != 0)
            this.que.add(this.temp.remove());
    }

    // O(1)
    public int peek() {
        return this.que.peek();
    }

    // O(1)
    public int pop() {
        return this.que.remove();
    }
}