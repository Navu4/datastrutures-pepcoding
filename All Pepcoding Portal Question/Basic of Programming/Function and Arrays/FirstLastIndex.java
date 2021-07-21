import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static void firstIdx(int[] arr,int data){
        for(int i = 0 ; i < arr.length ; i++){
            if(data == arr[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
    public static void lastIdx(int[] arr,int data){
        for(int i =  arr.length -1 ; i >= 0 ; i--){
            if(data == arr[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }

public static void main(String[] args) throws Exception {
    // write your code here
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt(); 
    }
    int data = scn.nextInt();
    firstIdx(arr,data);
    lastIdx(arr,data);
 }

}