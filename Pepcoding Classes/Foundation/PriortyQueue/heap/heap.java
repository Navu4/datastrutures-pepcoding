import java.util.ArrayList;

public class heap {
    private ArrayList<Integer> arr;
    private int size = 0;
    private boolean isMax = true;

    // Constructor ------------------
    public void initialize(boolean isMax) {
        this.arr = new ArrayList<>();
        this.size = 0;
        this.isMax = isMax;
    }

    public heap() {
        initialize(true);
    }

    public heap(int[] arr) { // O(n)
        initialize(true);
        for (int ele : arr) {
            this.arr.add(ele);
        }

        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }

        this.size = this.arr.size();
    }
    
    public heap(int[] arr, boolean isMax) { // O(n)
        initialize(isMax);
        for (int ele : arr) {
            this.arr.add(ele);
        }

        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }

        this.size = this.arr.size();
    }
    public heap(ArrayList<Integer> arr) { // O(n)
        initialize(true);
        this.arr = arr;

        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }

        this.size = this.arr.size();
    }
    public heap(ArrayList<Integer> arr, boolean isMax) { // O(n)
        initialize(isMax);
        this.arr = arr;

        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }

        this.size = this.arr.size();
    }

    // ---------------------------------------

    // Basic Function ------------------
    public int size() {
        return size;
    }

    public int peek() {
        return this.arr.get(0);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int compareTo(int a,int b){
        if(isMax){
            return this.arr.get(a) - this.arr.get(b);
        }else{
            return this.arr.get(b) - this.arr.get(a);
        }

    }

    // -------------------------------

    // Down Heapify
    private void swap(int i, int j) { // O(1)
        int ei = arr.get(i);
        int ej = arr.get(j);

        arr.set(i, ej);
        arr.set(j, ei);
    }

    private void downHeapify(int pi) { // O(logn)
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < this.arr.size() && compareTo(lci,maxIdx) > 0)
            maxIdx = lci;
        if (rci < this.arr.size() && compareTo(rci,maxIdx) > 0)
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    // Remove function
    public int remove() { // O(logn)

        int n = this.arr.size();
        int rv = this.arr.get(0);

        swap(0, n - 1);
        this.arr.remove(n - 1);
        downHeapify(0);

        this.size--;

        return rv;
    }


    // Add Function 
    // Up heapify
    private void upHeapify(int ci) {
        int pi = (ci - 1) / 2;

        if(pi >= 0 && compareTo(ci,pi) > 0){
            swap(pi, ci);  
            upHeapify(pi);
        }
    }

    public void add(int data) {
        this.arr.add(data);
        this.size++;
        upHeapify(this.arr.size() - 1);
    }
}