import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static void printAllSubArrays(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i ;j < arr.length ; j++){
                for(int k = i ; k <= j; k++){
                    System.out.print(arr[k] +"	") ;
                }
                System.out.println();
            }
            
        }
    }
public static void main(String[] args) throws Exception {
    // write your code here
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();   
    }
    printAllSubArrays(arr);
 }

}