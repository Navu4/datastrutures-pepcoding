class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }


    }
    private HashMap<Integer, Node> map = new HashMap<>();

    private Node head = null, tail = null;
    private int size = 0, capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        makeRecent(map.get(key));
        return this.tail.value;
    }

    private void addLast(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        } else {
            tail.next = node;
            node.prev = this.tail;

            this.tail = node;
        }

        size++;
    }

    private void removeNode(Node node){
        if(this.size == 1)
            this.head = this.tail = null;
        else {
            Node prev = node.prev;
            Node forw = node.next;

            if(prev == null){
                forw.prev = null;
                this.head = forw;
            } else if(forw == null){
                prev.next = null;
                this.tail = prev;
            } else {
                prev.next = forw;
                forw.prev = prev;
            }

            node.prev = node.next = null;
        }
        this.size--;
    }


    private void makeRecent(Node node){
        if(this.tail == node)
            return;

        removeNode(node);  // remove node from linkedlist
        addLast(node);       
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;

            makeRecent(node);
        } else {
            if(this.size == this.capacity){  
                int rKey = this.head.key;
                removeNode(this.head);

                map.remove(rKey);
            }
            Node node = new Node(key, value);
            addLast(node);

            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */