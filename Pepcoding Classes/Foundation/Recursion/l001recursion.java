import java.io.*;
import java.util.*;

public class l001recusion {
    public static Scanner scn = new Scanner(System.in);
    
    // print in decreasiong order
    public static void printDecreasing(int n) {
        if(n == 0) return;
        
        System.out.println(n);
        printDecreasing(n-1);
    }

    // Print in increasing order
    public static void printIncreasing(int n) {
        if(n == 0) return;
        
        printIncreasing(n-1);
        System.out.println(n);
    }

    // First Decreasing then Increasing
    public static void pdi(int n) {
        if(n == 0) return; 
        
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    // Factorial of a number using recursion
    public static int factorial(int n) {
        if(n <= 1) return 1;
        
        return n*factorial(n-1);
        
        // Or
        // return n == 0 ? 1 : n * factorial(n -1);
    }

    // Linear Power
    public static int power(int x, int n) {
        if(n == 0) return 1;
        return x * power(x,n-1);
    }

    public static int logPower(int x, int n) {
        if(n==-1)
            return 1/x;
        if(n==0)
            return 1;
        if(n==1)
            return x;
        int smallAns = power(x, n / 2);
        smallAns *= smallAns;

        return (n % 2 == 0 ? smallAns : smallAns * x);
    }

    // ZigZag pattern
    public static void pzz(int n) {
        if (n < 1) return;

        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        printDecreasing(n);
    }
}