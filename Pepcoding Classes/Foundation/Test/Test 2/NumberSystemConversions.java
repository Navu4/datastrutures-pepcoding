import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    
    public static int anyBaseToDecimal(int n, int base){
        int res = 0, pow = 1;
        while(n != 0){
            int rem = n % 10;
            n /= 10;
            
            res += rem * pow;
            pow *= base;
        }
        
        return res;
    }
    
    public static int decimalToAnyBase(int n, int base){
        int res = 0, pow = 1;
        while(n != 0){
            int rem = n % base;
            n /= base;
            
            res += rem * pow;
            pow *= 10;
        }
        
        return res;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        
        int decimalNum = anyBaseToDecimal(n, b1);
        
        System.out.println(decimalToAnyBase(decimalNum, b2));
    }
}