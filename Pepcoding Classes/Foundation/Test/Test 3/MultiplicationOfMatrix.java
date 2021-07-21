import java.util.*;
public class MultiplicationOfMatrix {
    public static Scanner scn = new Scanner(System.in);
    
    public static int[][] multiplicationOfTwoMatrix(int[][] arr1, int[][] arr2){
        int i;
        int j;
        int k;
        int N = arr1.length;
        int[][] res = new int[N][N];
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                res[i][j] = 0;
                for (k = 0; k < N; k++){
                    res[i][j] += arr1[i][k]* arr2[k][j];
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int r = scn.nextInt();
        int c = scn.nextInt();
        
        if(r != c){
            return;
        }
        
        int[][] arr1 = new int[r][c];
        int[][] arr2 = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr1[i][j] = scn.nextInt();
            }
        }
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr2[i][j] = scn.nextInt();
            }
        }
        
        int[][] res = multiplicationOfTwoMatrix(arr1, arr2);
        display(res);
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
