import java.io.*;
import java.util.*;

public class ReplaceHiWithpep {
    public static Scanner scn = new Scanner(System.in);

    public static String replaceHiWithPep(String str, int idx) {

        if (idx >= str.length() - 1) {
            if (idx == str.length() - 1)
                return "" + str.charAt(idx);
            else
                return "";
        }

        String s = str.substring(idx, idx + 2);

        if (s.equals("hi"))
            return "pep" + replaceHiWithPep(str, idx + 2);
        else
            return "" + str.charAt(idx) + replaceHiWithPep(str, idx + 1);
    }

    public static void replaceHiWithPep(String str, int idx, String ans) {

        if (idx >= str.length() - 1) {
            if (idx == str.length() - 1)
                System.out.println(ans + str.charAt(idx));
            else
                System.out.println(ans);
            return;
        }

        String s = str.substring(idx, idx + 2);
        if (s.equals("hi"))
            replaceHiWithPep(str, idx + 2, ans + "pep");
        else
            replaceHiWithPep(str, idx + 1, ans + str.charAt(idx));
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        String s = scn.next();
        int i = scn.nextInt();

        String res = replaceHiWithPep(s, 0);

        System.out.println(res.charAt(i));

        replaceHiWithPep(s, 0, "");
    }
}
