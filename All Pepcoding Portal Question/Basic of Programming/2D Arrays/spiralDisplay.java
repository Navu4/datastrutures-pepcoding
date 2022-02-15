import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static void spiralDisplay(int[][] arr){
        
        int n = arr.length, m = arr[0].length, count = n * m;
        int rmin = 0, rmax = n - 1;
        int cmin = 0, cmax = m - 1;
         
        while(count != 0){

            for(int r = rmin; r <= rmax && count > 0; r++){
                System.out.println(arr[r][cmin]);
                count--;
            }
            cmin++;

            
            for(int c = cmin; c <= cmax && count > 0; c++){
                System.out.println(arr[rmax][c]);
                count--;
            }
            rmax--;

            for(int r = rmax; r >= rmin && count > 0; r--){
                System.out.println(arr[r][cmax]);
                count--;
            }
            cmax--;

            for(int c = cmax; c >= cmin && count > 0; c--){
                System.out.println(arr[rmin][c]);
                count--;
            }
            rmin++;
        }

    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
               arr[i][j] = scn.nextInt();
        }
        spiralDisplay(arr);
    }

}