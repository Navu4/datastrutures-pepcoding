public class Queue<K>{
    protected K[] arr;
    protected int elementCount = 0;
    protected int capacity = 0;
    protected int front = -1;
    protected int back = -1;

    // Constructor
    public void initializer(int size) {
        this.capacity = size;
        this.arr = new K[size];
        this.elementCount = 0;
        this.front = -1;
        this.back = -1;
    }

    public Queue() {
        initializer(10);
    }

    public Queue(int size) {
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
        return this.arr[this.front];
    }

    // PUSH

    protected void add_(K data){
        this.arr[++back] = data;
        this.elementCount++;
    }
    public void add(K data) throws Exception {
        overflowException();
        add_(data);
    }

    // POP
    protected K remove_(){
        K rv = this.arr[this.front];
        this.arr[this.front] = null;

        this.front = ;
        this.elementCount--;
        return rv;
    }
    public K remove() throws Exception {
        underflowException();
        return pop_();
    }
}