import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {

    private class Node {
        int key = 0;
        int value = 0;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private LinkedList<Node>[] buckets;
    private int NoOfElements = 0;
    private int maxSizeOfBucket = 0;

    private void initialize(int size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }

        this.maxSizeOfBucket = size;
    }

    public HashMap(){
        initialize(10);
    }

    public HashMap(Integer size){
        initialize(size);
    }

    public Integer size(){
        return this.NoOfElements;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int sizeOfMap = this.NoOfElements;

        for (int i = 0; i < this.maxSizeOfBucket; i++) {
            LinkedList<Node> group = this.buckets[i];
            int size = group.size();
            while (size-- > 0) {
                sb.append(group.getFirst());
                if (sizeOfMap > 1)
                    sb.append(",");

                group.addLast((group.removeFirst()));
                sizeOfMap--;
            }
        }

        sb.append("]");
        return sb.toString();
    }

    private void rehash(){
        LinkedList<Node>[] temp = this.buckets;
        initialize(2 * this.maxSizeOfBucket);

        for (int i = 0; i < temp.length; i++) {
            LinkedList<Node> group = temp[i];
            int size = group.size();
            while (size-- > 0) {
                Node node = group.removeFirst();
                put(node.key, node.value);
            }
        }
    }

    public void put(Integer key, Integer value) {
        LinkedList<Node> group = group(key);
        boolean res = containsKey(key);
        if (res) {
            group.getFirst().value = value;
        } else {
            Node node = new Node(key, value);
            group.addLast(node);
            this.NoOfElements++;

            double lambda = (0.4 * this.maxSizeOfBucket);
            if(group.size() >= lambda){
                rehash();
            }
        }
    }

    // Get function using containsKey function
    // if you found return value if not return null.
    public Integer get(Integer key) {
        if (containsKey(key))
            return group(key).getFirst().value;
        else
            return null;
    }

    // Remove function
    public Integer remove(Integer key) {
        LinkedList<Node> group = group(key);
        boolean res = containsKey(key);
        if (res) {
            this.NoOfElements--;
            return group.removeFirst().value;
        } else {
            return null;
        }
    }

    // KeySet Function
    private void allkeysOfGroup(LinkedList<Node> group, ArrayList<Integer> ans) {
        int size = group.size();
        while (size-- > 0) {
            ans.add(group.getFirst().key);

            group.addLast(group.removeFirst());
        }
    }

    public ArrayList<Integer> keySet() {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < this.maxSizeOfBucket; i++) {
            allkeysOfGroup(this.buckets[i], ans);
        }

        return ans;
    }

    // Containskey function
    public boolean containsKey(Integer key) {
        LinkedList<Node> group = group(key);
        int size = group.size();
        while (size-- > 0) {
            if (group.getFirst().key == key)
                return true;

            group.addLast(group.removeFirst());
        }
        return false;
    }

    // getOrDefault function
    public Integer getOrDefault(Integer key, Integer defaultValue) {
        Integer value = get(key);
        if (value == null)
            return defaultValue;

        return value;
    }

    // Most Important function
    // Group and groupNo
    private LinkedList<Node> group(int key) {
        int groupNo = groupNo(key);
        return this.buckets[groupNo];
    }

    private Integer groupNo(Integer key) {
        Integer hc = Math.abs(key.hashCode());
        return hc % maxSizeOfBucket;
    }

}
