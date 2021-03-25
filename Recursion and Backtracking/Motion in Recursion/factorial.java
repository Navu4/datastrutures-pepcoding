import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        System.out.print(factorial(n));
    }

    public static int factorial(int n) {
        if(n <= 1) return 1;
        
        return n*factorial(n-1);
    }

}