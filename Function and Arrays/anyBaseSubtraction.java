import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
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