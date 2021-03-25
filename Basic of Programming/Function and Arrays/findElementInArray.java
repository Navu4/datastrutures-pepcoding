import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static int findElement(int[] arr,int key){
        int idx = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                idx = i;
                break;
            }
        }
        return idx;
    }
public static void main(String[] args) throws Exception {
    // write your code here
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < arr.length; i++){
        arr[i] = scn.nextInt();
    }
    
    int key = scn.nextInt();
    
    System.out.print(findElement(arr,key));
 }

}