public class stack {
    protected int[] arr = null;
    protected int capacity = 0; // maximum element that array can hold in it.
    protected int elementCount = 0; // No of elements present in stack.
    protected int tos = -1;

    // constructor ================================

    protected void initializer(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.elementCount = 0;
        this.tos = -1;
    }

    public stack() {
        initializer(10);
    }

    public stack(int size) {
        initializer(size);
    }

    // Basic function =============================
    public int size() {
        return this.elementCount;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elementCount; i++) {
            sb.append(this.arr[i]);

            if (i != elementCount - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Exceptions =================================
    private void OverflowException() throws Exception {
        if (this.capacity == this.elementCount) {
            throw new Exception("StackIsFull");
        }
    }

    private void underFlowException() throws Exception {
        if (this.elementCount == 0)
            throw new Exception("StackIsEmpty");
    }

    // Stack Function ===============================
    // PUSH
    protected void push_(int data) {
        this.arr[++tos] = data;
        this.elementCount++;
    }

    public void push(int data) throws Exception {
        OverflowException();
        push_(data);
    }

    public int top() throws Exception {
        underFlowException();
        return this.arr[this.tos];
    }

    // POP ============================
    protected int pop_() {
        int rv = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.elementCount--;

        return rv;
    }

    public int pop() throws Exception {
        underFlowException();
        return pop_();
    }
}