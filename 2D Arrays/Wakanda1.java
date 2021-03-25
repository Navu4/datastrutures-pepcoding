import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static void waveprint(int[][] arr, int row, int col){
        for(int j = 0; j < col; j++){
            if(j % 2 == 0){
                for(int i = 0 ; i < row ; i++){
                    System.out.println(arr[i][j] + " ");
                }
            } else
            {
                for(int i = row - 1 ; i >= 0 ; i--){
                    System.out.println(arr[i][j] + " ");
                }
            }
            
        }
    }
public static void main(String[] args) throws Exception {
    // write your code here
    int n = scn.nextInt();
    int m = scn.nextInt();;
    
    int[][] arr = new int[n][m];
    for(int i= 0; i < arr.length; i++){
        for(int j=0; j < arr[0].length;j++){
            arr[i][j] = scn.nextInt();
        }
    }
    waveprint(arr,n,m);
}

}