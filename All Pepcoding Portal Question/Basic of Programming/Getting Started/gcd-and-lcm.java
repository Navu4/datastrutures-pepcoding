import java.util.*;
    
    public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static int LCM(int a, int b){
        return ((a/GCD(a,b)) * b);
    }
    
    public static int GCD(int a, int b){
        int divisior = a;
        int dividend = b;
        
        while(dividend % divisior != 0){
            
            int rem = dividend % divisior;
            dividend = divisior;
            divisior = rem;
            
        }
        
        return divisior;
    }
    public static void main(String[] args) {
      // write your code here  
        int a = scn.nextInt();   
        int b = scn.nextInt();   
        
        int gcd = GCD(a,b);
        System.out.println(gcd);
        System.out.println(LCM(a,b));
        
    }
}