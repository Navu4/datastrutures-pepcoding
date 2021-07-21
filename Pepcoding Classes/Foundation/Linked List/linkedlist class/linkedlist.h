#include<iostream>
using namespace std;

class linkedlist
{
private:
    class Node
    {
    public:
        int data = 0;
        Node *next = nullptr;

        Node(int data)
        {
            this->data = data;
        }
    };

    Node *head = nullptr;
    Node *tail = nullptr;
    int sizeOfLL = 0;

public:
    bool isEmpty()
    {
        return this->sizeOfLL == 0;
    }

    int size()
    {
        return this->sizeOfLL;
    }

    void display()
    {
        Node *curr = this->head;
        while (curr != nullptr)
        {
            cout << curr->data << " -> ";
            curr = curr->next;
        }
        cout << endl;
    }

    // Exceptions
    private:
        void EmptyException()
        {
            if (this->sizeOfLL == 0)
            {
                cout << "LinkedList is Empty: -1" << endl;
                throw -1;
            }
        }

        void IndexOutOfBoundSizeExclusiveException(int idx)
        {
            if (idx < 0 || idx >= this->sizeOfLL)
            {
                cout << "Index Out Of Bound: -1" << endl;
                throw -1;
            }
        }

        void IndexOutOfBoundSizeInclusiveException(int idx)
        {
            if (idx < 0 || idx > this->sizeOfLL)
            {
                cout << "Index Out Of Bound: -1" << endl;
                throw -1;
            }
        }
    
    // Get ===============================================================================

    public:
        int getFirst(){
            EmptyException();
            return this->head->data;
        }

        int getLast(){
            EmptyException();
            return this->tail->data;
        }

    private:
        Node* getNodeAt(int idx){
            Node *curr = this->head;
            while (idx-- >0)
            {
                curr = curr->next;
            }
            return curr;
        }

    public:
        int getAt(int idx){
            IndexOutOfBoundSizeExclusiveException(idx);
            Node* node = getNodeAt(idx);
            return node->data;    
        }

     // Add_===========================================================================
    private:
     void addFirstNode(Node *node) {
        if (this->head == NULL) {
            this->head = node;
            this->tail = node;
        } else {
            node->next = this->head;
            this->head = node;
        }

        this->sizeOfLL++;
    }

    public:
     void addFirst(int data) {
        Node *node = new Node(data);
        addFirstNode(node);
    }

    private:
     void addLastNode(Node* node) {
        if (this->head == NULL) {
            this->head = node;
            this->tail = node;
        } else {
            this->tail->next = node;
            this->tail = node;
        }

        this->sizeOfLL++;
    }

    public:
     void addLast(int data) {
        Node* node = new Node(data);
        addLastNode(node);
    }

    private:
     void addAtNode(int idx, Node *node) {
        if (idx == 0)
            addFirstNode(node);
        else if (idx == this->sizeOfLL)
            addLastNode(node);
        else {
            Node *prev = getNodeAt(idx - 1);
            Node *forw = prev->next;

            prev->next = node;
            node->next = forw;

            this->sizeOfLL++;
        }
    }

    public:
     void addAt(int idx, int data) {
        IndexOutOfBoundSizeInclusiveException(idx);
        Node *node = new Node(data);
        addAtNode(idx, node);
    }

    // remove_========================================================================

    private:
     Node* removeFirstNode() {
        Node *removeNode = this->head;
        if (this->sizeOfLL == 1) {
            this->head = NULL;
            this->tail = NULL;
        } else {
            Node *forw = this->head->next;
            removeNode->next = NULL;
            this->head = forw;
        }

        this->sizeOfLL--;
        return removeNode;
    }

    public:
     int removeFirst() {
        EmptyException();
        Node* node = removeFirstNode();
        return node->data;
    }

    private:
     Node* removeLastNode() {
        Node* removeNode = this->tail;
        if (this->sizeOfLL == 1) {
            this->head = NULL;
            this->tail = NULL;
        } else {
            Node* secondLastNode = getNodeAt(this->sizeOfLL - 2);
            this->tail = secondLastNode;
            this->tail->next = NULL;
        }

        this->sizeOfLL--;
        return removeNode;

    }

    public:
     int removeLast() {
        EmptyException();
        Node *node = removeLastNode();
        return node->data;
    }

    private:
     Node* removeNodeAt(int idx) {
        if (idx == 0)
            return removeFirstNode();
        else if (idx == this->sizeOfLL - 1)
            return removeLastNode();
        else {
            Node *prev = getNodeAt(idx - 1);
            Node *curr = prev->next;
            Node *forw = curr->next;

            prev->next = forw;
            curr->next = NULL;

            this->sizeOfLL--;
            return curr;
        }

    }

    public:
     int removeAt(int idx) {
        EmptyException();
        IndexOutOfBoundSizeExclusiveException(idx);
        Node* node = removeNodeAt(idx);
        return node->data;
    }

};