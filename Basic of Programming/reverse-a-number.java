import java.util.*;
   
   public class Main{
   public static Scanner scn = new Scanner(System.in);
   public static void reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = num%10;
            num /= 10;
            System.out.println(rev);
        }
   }
   public static void main(String[] args) {
     // write your code here  
       int num = scn.nextInt();
       
       reverse(num);
   }
   }