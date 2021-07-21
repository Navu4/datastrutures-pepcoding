import java.util.Stack;

public class queueUsingStack_push {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    int peekVal = 0;

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    // O(1)
    public void add(int data) {
        if (this.st.size() == 0)
            this.peekVal = data;

        this.st.push(data);
    }

    // O(1)
    public int peek() {
        return peekVal;
    }

    private void transferToAnotherStack() {
        while (this.st.size() != 0)
            this.temp.push(this.st.pop());
    }

    // O(n)
    public int remove() {
        transferToAnotherStack();
        int rData = this.temp.pop();

        while (this.temp.size() != 0) {
            this.st.push(this.temp.pop());
        }

        return rData;
    }

}