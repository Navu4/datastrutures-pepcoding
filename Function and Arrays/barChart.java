import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        
        printBarChart(arr, n);
    }
    
    public static void printBarChart(int[] arr, int col){
        int max = maxValue(arr);
        
        for(int floor = max; floor >= 1; floor--){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= floor){
                    System.out.print("*	");
                }   else {
                    System.out.print("	");
                }
            }
            
            System.out.println();
        } 
        
    }
    
    public static int maxValue(int[] arr){
        int maxEle = (int)(-1e9);
        for(int i = 0; i < arr.length; i++){
            if(maxEle < arr[i]){
                maxEle = arr[i];
            }   
        }
        return maxEle;
    }
}