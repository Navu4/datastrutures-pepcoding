public class LinkedList {
	private class Node {
		int data;
		Node next;


		// Constructor Overloading
		Node(){
			this.data = 0;
			this.next = null;
		}

		Node(int data){
			this.data = data;
			this.next = null;
		}

		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	private int sizeOfLL = 0;	// Size of LinkedList
	private Node head = null, tail = null;  // head and tail pointer 


	// Size function 
	public int size(){
		return this.sizeOfLL;
	}

	// Is List Empty
	public boolean isEmpty(){
		return this.sizeOfLL == 0;
	}


	// Exception Function=======================================
	
	// Exceptions
    private void EmptyException() throws Exception {
        if (this.sizeOfLL == 0) {
            throw new Exception("LinkedList is Empty: -1 pepcoding");
        }
    }

    private void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception {
        if (idx < 0 || idx >= this.sizeOfLL)	// idx  >= sizeOfLL
            throw new Exception("Index Out Of Bound : -1");
    }

    private void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception {
        if (idx < 0 || idx > this.sizeOfLL)    // idx  > sizeOfLL   = special thing 
            throw new Exception("Index Out Of Bound : -1");
    }



	// Add Functions=========================================

	// Add first 
	private void addFirstNode(Node node){
		if(this.head == null){
			this.head = this.tail = node;
		} else {
			node.next = this.head;
			this.head = node;
		}

		sizeOfLL++;
	}
	public void addFirst(int data){
		Node node = new Node(data);
		addFirstNode(node);
	}

	// Add Last
	private void addLastNode(Node node){
		if(this.head == null){
			this.head = this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node; 
		}
		sizeOfLL++;
	}

	public void addLast(int data){
		Node node = new Node(data);
		addLastNode(node);
	}

	// Add at Index
	private void addAtNode(int idx, Node node){
		if(idx == 0){
			addFirstNode(node);
		} else if(idx == this.sizeOfLL){
			addLastNode(node);
		} else {
			Node prev = getNodeAt(idx - 1); // Get Node at Function is downwards
			Node forw = prev.next;

			prev.next = node;
			node.next = forw;

			this.sizeOfLL++;  // Becoz addFirst and addLast handle it for themselves
 		}
	}
	public void addAt(int idx, int data){
		if(idx < 0 || idx > this.sizeOfLL){
			System.out.println("Invalid Argument");
			return;
		}

		Node node = new Node(data);
		addAtNode(idx, node);
	}


	// Get Functions=================================================

	// Get Node at
	// IMPORTANT FUNCTION
	private Node getNodeAt(int idx){
		Node curr = this.head;
		while(idx-- > 0){
			curr = curr.next;
		}
		return curr;
	}


	public int getAt(int idx) throws Exception {
		IndexOutOfBoundSizeExclusiveException(idx);

		Node node = getNodeAt(int idx);
		return node.data;
	}

	// Get First
	public int getFirst() throws Exception {
		EmptyException();
		return this.head.data;
	}

	// Get Last
	public int getLast() throws Exception {
		EmptyException();
		return this.tail.data;
	}



	// Remove Functions

	private Node removeFirstNode(){
		Node removeNode = this.head;

		if(this.sizeOfLL == 1){
			this.head = this.tail = null;
		} else {
			Node forw = this.head.next;
			this.head = forw;
		}

		removeNode.next = null;
		this.sizeOfLL--;

		return removeNode;
	}

	public int removeFirst() throws Exception {
		EmptyException();

		Node node = removeFirstNode();
		return node.data;
	}


	// Remove Last
	private Node removeLastNode(){
		Node removeNode = this.tail;

		if(this.sizeOfLL == 1){
			this.head = this.tail = null;
		} else {
			Node secondLastNode = getNodeAt(this.sizeOfLL - 1);

			this.tail = secondLastNode;
			this.tail.next = null;
		}

		this.sizeOfLL--;
		return removeNode;
	}

	public int removeLast() throws Exception {
		EmptyException();

		Node node = removeLastNode();
		return node.data;
	}


	// Remove At 
	private Node removeNodeAt(int idx){
		if(idx == 0){
			return removeFirstNode();
		} else if(idx == this.sizeOfLL - 1){
			return removeLastNode();
		} else {
			Node prev = getNodeAt(idx);
			Node curr = prev.next;
			Node forw = curr.next;


			prev.next = forw;
			curr.next = null;

			this.sizeOfLL--;
			return curr;
		}
	}

	public int removeAt(int idx) throws Exception {
		EmptyException();
		IndexOutOfBoundSizeInclusiveException(idx);
		Node node = removeNodeAt(idx);
		return node.data;
	}
}