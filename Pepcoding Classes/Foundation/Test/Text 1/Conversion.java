import java.util.Scanner;

public class Conversion {
    public static Scanner scn = new Scanner(System.in);

    public static String decimalToHexadecimal(long n) {
        long x = 1;
        StringBuilder ans = new StringBuilder();
        while (x <= n) {
            x *= 64;
        }
        x /= 64;

        while (x > 0) {
            long lastDigit = n / x;
            n -= lastDigit * x;
            x /= 64;

            if (lastDigit <= 9) {
                ans.append(lastDigit);
            } else {
                char c = (char) ((int) 'A' + (int) (lastDigit - 10));
                ans.append(c);
            }

        }
        return ans.toString();
    }

    public static long hexadecimalToDecimal(String n) {
        long ans = 0;
        long x = 1;

        int s = n.length();
        for (int i = s - 1; i >= 0; i--) {

            if (n.charAt(i) >= '0' && n.charAt(i) <= '9') {
                ans += (x * (n.charAt(i) - '0'));
            } else if (n.charAt(i) >= 'A' && n.charAt(i) <= '~') {
                ans += (x * (n.charAt(i) - 'A' + 10));
            }
            x *= 64;
        }

        return ans;
    }

    public static long stringToNumber(String str) {
        int len = str.length();

        long res = 0;
        int i = 0, j = 0;
        int pow = 1;
        while (j < len - 1) {
            pow *= 10;
            j++;
        }

        while (i < str.length()) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));

            res += num * pow;
            pow /= 10;

            i++;
        }

        return res;
    }

    public static long encode(String str, int[] freq) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int ch = freq[str.charAt(i) - 'a'];
            // System.out.print(str.charAt(i) + "->" + ch + " ");
            sb.append(ch);
        }
        System.out.println(sb);
        return (stringToNumber(sb.toString()));
    }

    public static String decode(long num) {
        String str = String.valueOf(num);

        StringBuilder sb = new StringBuilder();
        long x = 1;
        int i = 0;
        while (i < str.length() - 2) {
            x *= 10;
            i++;
        }

        while (num != 0) {
            long val = num / x;
            num = num % x;

            sb.append((char) ((int) 'a' + (int) (val - 10)));

            x /= 100;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = scn.next();

        int[] freq = new int[26];
        int val = 10;
        for (int i = 0; i < freq.length; i++) {
            freq[i] = val;
            val++;
        }
        // int num = scn.nextInt();

        long asciiNum = encode(str, freq);
        System.out.println(asciiNum);

        String hexaNum = decimalToHexadecimal(asciiNum);
        System.out.println(hexaNum);

        long numASCII = hexadecimalToDecimal(hexaNum);
        System.out.println(numASCII);

        String decodedString = decode(numASCII);
        System.out.println(decodedString);
    }
}
