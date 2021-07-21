import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_push {
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    int peekVal = 0;

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }


    // O(1)
    public void push(int data) {
        this.peekVal = data;
        this.que.add(data);
    }

    // O(1)
    public int peek() {
        return peekVal;
    }

    private void transferToAnotherQueue() {
        while (this.que.size() != 1)
            this.temp.add(this.que.remove());
    }

    // O(n)
    public int pop() {
        transferToAnotherQueue();
        int rData = this.que.remove();

        while (this.temp.size() != 0)
            this.que.add(this.temp.remove());

        return rData;
    }
}