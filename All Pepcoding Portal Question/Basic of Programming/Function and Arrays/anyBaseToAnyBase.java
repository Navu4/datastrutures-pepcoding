import java.util.*;

public class Main {

  public static Scanner scn = new Scanner(System.in);

  public static int getValueIndecimal(int n, int b) {
    // write your code here
    int res = 0;
    int pow = 1;

    while (n != 0) {
      int rem = n % 10;
      n /= 10;

      res += rem * pow;
      pow *= b;
    }
    return res;
  }

  public static int getValueInBase(int n, int b) {
    // write code here
    int res = 0;
    int pow = 1;

    while (n != 0) {
      int rem = n % b;
      n /= b;

      res += rem * pow;
      pow *= 10;
    }
    return res;
  }

  public static int anyBaseToAnyBase(int n, int b1, int b2) {
    int decimalValue = getValueIndecimal(n, b1);
    return getValueInBase(decimalValue, b2);
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    int sourceBase = scn.nextInt();
    int destBase = scn.nextInt();
    System.out.println(anyBaseToAnyBase(n, sourceBase, destBase));
  }
}