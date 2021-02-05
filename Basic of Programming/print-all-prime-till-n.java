import java.util.Scanner;

public class Main{
    public static Scanner scn = new Scanner(System.in);
    
    public static boolean isPrime_(int n){
        boolean prime = true;
        for (int i = 2; i*i <= n; i++){
            if(n % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }
    
    public static void printAllPrime(int a, int b){
        for(int i =a; i<=b ; i++){
            boolean ans = isPrime_(i);
            if(ans) System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        // write your code here
        int low = scn.nextInt();
        int high = scn.nextInt();
        
        printAllPrime(low,high);
    }
}