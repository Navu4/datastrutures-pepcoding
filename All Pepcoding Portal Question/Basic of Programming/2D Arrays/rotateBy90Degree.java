import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static void rotate90(int[][] arr){
        
        // Transpose
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i] ; 
                arr[j][i] = temp ; 
            }
        }
        
        int c1 = 0;
        int c2 = n -1;
        while(c1 < c2){
            
            for(int i = 0 ; i < n; i++){
                int temp = arr[i][c1];
                arr[i][c1] = arr[i][c2] ; 
                arr[i][c2] = temp ; 
            }
            c1++;
            c2--;
        } 
        
        display(arr);
    }
    
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i= 0 ;i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        rotate90(arr);
    }


}