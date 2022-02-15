import java.util.Scanner;
  
  public class Main{
  public static Scanner scn = new Scanner(System.in);
  
  public static void countDigit(int n){
        int count = 0 ;
        while(n > 0){
            n /= 10;
            count++;
        }
        System.out.println(count);
  }
  public static void main(String[] args) {
    // write your code here  
    int n = scn.nextInt();
    countDigit(n);
   }
  }