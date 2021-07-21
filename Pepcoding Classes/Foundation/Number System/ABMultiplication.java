import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
}

    public static int getProduct(int b, int n1, int n2){

        int rv = 0;
        int p = 1;

        while(n2 > 0){
            int d2 = n2 % 10;
            n2 = n2 / 10;

            int sprd = getProductWithASingleDigit(b, n1, d2);

            rv = getSum(b, rv, sprd * p);
            p = p * 10;
        }

        return rv;
    }

    public static int getProductWithASingleDigit(int b, int n1, int d2){
        int rv = 0;
        int p = 1
        int c = 0;
        while(n1 > 0 || c > 0 ){
            int d1 = n1 % 10;
            n1 = n1 / 10;

            int d = d1 * d2 + c;

            c = d / b;
            d = d % b;

            rv = rv + d*p;
            p = p * 10;
        }
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
}