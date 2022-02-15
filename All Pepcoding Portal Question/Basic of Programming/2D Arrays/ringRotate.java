import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static void reverse(int[] arr,int i ,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void rotate(int[] arr, int r){
        int n = arr.length;
        // if(r < 0){
        //     r = r + arr.length;
        // }
        r = (r %n + n) % n;
        reverse(arr,0,n-1);
        reverse(arr,0,r-1);
        reverse(arr,r,n-1);
    }
    
    public static int[] filloOneDfromShell(int[][] arr,int s){
        int n = arr.length;
        int m = arr[0].length;
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = n - s;
        int cmax = m - s;
        
        // int sz = lw + bw + rw + tw - 4 ; 
        // int sz = 2 *lw + 2 * bw - 4 ; 
        // int sz = 2 * (rmax - rmin + 1) + 2 * (cmax - cmin + 1) - 4 ; 
        int sz = 2*rmax - 2*rmin + 2*cmax - 2*cmin ; 
        
        int[] oned = new int[sz];
        
        // lw
        int idx = 0;
        for(int i = rmin , j = cmin; i <= rmax ; i++){
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // bw
        for(int i = rmax, j = cmin + 1; j <= cmax ; j++){
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // rw 
        for(int i = rmax - 1, j = cmax ; i >= rmin ; i--){
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // tw
        for(int i = rmin , j = cmax - 1 ; j >= rmin + 1 ; j--){
            oned[idx] = arr[i][j];
            idx++;
        }
        return oned;
    }
    public static void fillShellFromOneD(int[][] arr,int s,int[] oned){
        int n = arr.length;
        int m = arr[0].length;
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = n - s;
        int cmax = m - s;
        
        
        // lw
        int idx = 0;
        for(int i = rmin , j = cmin; i <= rmax ; i++){
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // bw
        for(int i = rmax, j = cmin + 1; j <= cmax ; j++){
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // rw 
        for(int i = rmax - 1, j = cmax ; i >= rmin ; i--){
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // tw
        for(int i = rmin , j = cmax - 1 ; j >= rmin + 1 ; j--){
            arr[i][j] = oned[idx];
            idx++;
        }
    }
    
    public static void shellrotate(int[][] arr,int s,int r){
        int[] oneD = filloOneDfromShell(arr,s);
        rotate(oneD,r);
        fillShellFromOneD(arr,s,oneD);
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt(); 
            }
        }
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        shellrotate(arr,s,r);
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

}