public class dynamicStack extends    {

    // Constructor
    public dynamicStack() {
        super();
    }

    public dynamicStack(int size) {
        super(size);
    }

    public dynamicStack(int[] arr) {
        super.initializer(arr.length * 2);

        for (int ele : arr)
            super.push_(ele);
    }

    // @Override
    protected void push_(int data) {
        if (super.capacity == super.elementCount) {
            int[] temp = super.arr;
            super.initializer(2 * super.capacity);
            for (int ele : temp)
                super.push_(ele);
        }

        super.push_(data);
    }

    public void push(int data) {
        push_(data);
    }
}