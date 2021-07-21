import java.util.Scanner;
public class DTB{

    public static Scanner 
    public static int decimalToBinary(int n){
        int res = 0;
        int pow = 1;

        while(n != 0){
            int rem = n % 1;
            n /= 2;

            res += rem*pow;
            pow *= 10;
        }
        return res;
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        System.out.println(decimalToBinary(n));
    }
}