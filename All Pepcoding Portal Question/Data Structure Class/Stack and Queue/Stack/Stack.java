import java.util.Arrays;
public class Stack<K> {

    protected K[] arr;
    protected int elementCount = 0;
    protected int capacity = 0;
    protected int top = -1;

    // Constructor
    public void initializer(int size) {
        this.capacity = size;
        this.arr = new K[size];
        this.elementCount = 0;
        this.top = -1;
    }

    public Stack() {
        initializer(10);
    }

    public Stack(int size) {
        initializer(size);
    }
    // ---------------------------------------------------------

    // Exceptions
    public void overflowException() throws Exception {
        if (this.elementCount == this.capacity) {
            throw new Exception("Overflow");
        }
    }

    public void underflowException() throws Exception {
        if (this.elementCount == 0) {
            throw new Exception("Underflow");
        }
    }
    //------------------------------------------------

    // isEmpty
    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    // Size
    public int size() {
        return this.elementCount;
    }

    // Peek/Top
    public K peek() throws Exception {
        underflowException();
        return this.arr[this.top];
    }

    // PUSH

    protected void push_(K data){
        this.arr[++top] = data;
        this.elementCount++;
    }
    public void push(K data) throws Exception {
        overflowException();
        push_(data);
    }

    // POP
    protected K pop_(){
        K rv = this.arr[this.top];
        this.arr[this.top] = null;

        this.top--;
        this.elementCount--;
        return rv;
    }
    public K pop() throws Exception {
        underflowException();
        return pop_();
    }
}