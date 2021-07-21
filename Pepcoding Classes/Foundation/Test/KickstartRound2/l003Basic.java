import java.util.ArrayList;
import java.util.Scanner;

public class l003Basic {
    public static Scanner scn = new Scanner(System.in);

    public static boolean isPrime(Long n) {
        for (long i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;

        }
        return true;
    }


    public static void solve(int caseNo, long z){
        long a = 0, b;
        long ans = -1;
        boolean valueOfA = true;
        for (long i = (long)Math.sqrt(z); i >= 0; i--) {

            if(isPrime(i)){
                if(valueOfA){
                    System.out.println(i);
                    a = i;
                    valueOfA = false;
                    continue;
                }

                b = i;
                long val = a * b;
                a = b;
                System.out.println(val + " " + z);
                if (val < z)  ans = val;
                if( val == z) { ans = val; break;}
            }
        }

        System.out.println("Case #" + caseNo + ": " + ans);
    }

    public static void main(String[] args) {
        long T = scn.nextLong();
        int idx = 1;
        
        while (idx <= T) {
            long z = scn.nextLong();
            solve(idx, z); // , ans);
            idx++;
        }
    }
}
