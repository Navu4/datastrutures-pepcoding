import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n) {
        if(n == 0) return;
        
        System.out.println(n);
        printDecreasing(n-1);
    }

}