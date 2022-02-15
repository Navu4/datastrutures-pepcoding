import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);
    
    public static void SearchIn2DArray(int[][] arr,int data){
        int j = 0 ;
        int i = arr.length - 1;
        while(i >= 0 && j < arr[0].length ){
            
            if(arr[i][j] == data){
                System.out.print(i + "
" + j);
                return;
            }
            else if(arr[i][j] < data){
                j++;
            }
            else{
                i--;
            }
        }
        System.out.println("Not Found");
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
        int key = scn.nextInt();
        SearchIn2DArray(arr,key);
    }

}