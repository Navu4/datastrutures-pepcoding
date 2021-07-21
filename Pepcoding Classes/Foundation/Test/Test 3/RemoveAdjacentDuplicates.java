import java.io.*;
import java.util.*;


// Using LinkedList
public class RemoveAdjacentDuplicates {
    public static Scanner scn = new Scanner(System.in);
    public static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
        }
        
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    
    public static Node removeDuplicatesFromList(Node head){
        if(head == null || head.next == null)   
            return null;
        
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            if(curr.data == prev.data){
                prev.next = curr.next;
                curr = prev.next;
                
                continue;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        
        return head;
    }
    
    public static  void display(Node head){
        if(head == null)    return;
        
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " "); 
            curr = curr.next;
        }
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = scn.nextInt();
        Node head = new Node(-(int)1e9);
        Node curr = head;
        while(n-- > 0){
            int data = scn.nextInt();
            curr.next = new Node(data);
            
            curr = curr.next;
        }
        
        Node newHead = removeDuplicatesFromList(head.next);
        
        display(newHead);
    }
}
