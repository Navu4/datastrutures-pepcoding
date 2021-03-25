import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);    
    public static void saddlepoint(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int r = 0; r < n ; r++){
            int c = 0;
            int minEle = (int)1e8;

            for(int j = 0; j < m ; j++){
                if(arr[r][j] < minEle){
                    minEle = arr[r][j];
                    c = j;
                }
            }

            boolean isSaddlePoint = true;

            for(int i = 0; i < n ; i++){
                if(arr[i][c] > minEle){
                    isSaddlePoint = false;
                    break;
                }
            }
            if(isSaddlePoint){
                System.out.print(minEle);
                return ;
            }
        }
        System.out.print("Invalid input");
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
        saddlepoint(arr);    
    }

}