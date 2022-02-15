import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static void display(int[][] arr){
        for(int i= 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    int n = scn.nextInt();
    int m = scn.nextInt();
    
    int[][] arr = new int[n][m];
    for(int i= 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
            arr[i][j] = scn.nextInt();
        }
    }
    display(arr);
 }

}