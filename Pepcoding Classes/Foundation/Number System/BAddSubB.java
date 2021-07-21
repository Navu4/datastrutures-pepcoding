import java.util.*;
  
  public class BAddSubB{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int m = scn.nextInt();
      int d = getValueIndecimal(n, m);
      System.out.println(d);
   }
  
   public static int addition(int n, int m){
        // write your code here
        int res = 0;
        int pow = 1;
        int carry = 0;
        while(n!= 0 || m!=0 || carry !=0){
            int r1 = n % 10;
            int r2 = n % 10;

            n /= 10;
            m /= 10;

            int sum = r1 + r2 + carry;
            int r = sum % 2;
            carry = sum / 2;

            res += r*pow;
            pow *= 10;
        }
        return res;
   }
   public static int getDifference(int b,int n,int m){
        int res = 0, pow = 1, borrow = 0;
        while(n != 0 || m !=0){
            int r1 = n % 10;
            int r2 = m % 10;

            n /= 10;
            m /= 10;

            int subtract = r2 - r1 + borrow;
            if(subtract < 0){
                subtract += b;
                borrow = -1;
            }else borrow = 0;

            res += subtract * pow;
            pow *= 10;
        }

        return res;
    }
  }