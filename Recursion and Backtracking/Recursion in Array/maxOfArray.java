import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = scn.nextInt();

        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length) return -(int) 1e9;

        int maxofSmallSeg = maxOfArray(arr, idx + 1);
        return Math.max(arr[idx], maxofSmallSeg);
    }

}