import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = scn.nextInt();
        int x = scn.nextInt();
        System.out.println(lastIndex(arr,0,x));
    }

    public static int lastIndex(int[] arr, int idx, int data) {
        if(idx == arr.length) return -1;
        
        int ans = lastIndex(arr,idx + 1,data);
        if(ans != -1) return ans;
        
        return (arr[idx] == data ? idx : -1);
    }

}