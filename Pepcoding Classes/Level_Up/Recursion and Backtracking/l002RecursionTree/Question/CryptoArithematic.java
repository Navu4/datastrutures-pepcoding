import java.util.*;

public class CryptoArithematic {
    static String s1 = "send";
    static String s2 = "more";
    static String s3 = "money";

    static boolean[] used = new boolean[10];
    // static int[] map = new int[26];
    static int[] map = new int[128];

    public static void displayMap() {
        for (int i = 0; i < map.length; i++) {
            if (map[i] > -1)
                System.out.print((char) i + "-" + map[i] + " ");
        }

        System.out.println();
    }

    public static int convertStringToNumber(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            res = res * 10 + map[ch];
        }

        return res;
    }

    public static int cryptoArithematic(String str, int idx) {
        if (idx == str.length()) {
            if (map[s1.charAt(0)] == 0 || map[s2.charAt(0)] == 0 || map[s3.charAt(0)] == 0)
                return 0;

            int x = convertStringToNumber(s1);
            int y = convertStringToNumber(s2);
            int z = convertStringToNumber(s3);

            if (x + y == z) {
                displayMap();
                return 1;
            }

            return 0;
        }

        char ch = str.charAt(idx);
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                // map[ch - 'a'] = i;
                map[ch] = i;

                count += cryptoArithematic(str, idx + 1);

                map[ch] = -1;
                used[i] = false;
            }
        }

        return count;
    }

    public static void cryptoArithematic() {
        String str = s1 + s2 + s3;

        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        str = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                str += (char) (i + 'a');
        }

        Arrays.fill(map, -1);
        cryptoArithematic(str, 0);
    }

    // =============================================================
    

    public static void displayMap(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] > -1)
                System.out.print((char)(i + 'A') + "-" + map[i] + " ");
        }

        System.out.println();
    }

    public static int convertStringToNumber2(String str, int[] map){
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            res = res*10 + map[ch - 'A'];
        }
        return res;
    }

    public static int crypto(String[] words, String res, String str, int idx, int[] map, boolean[] used) {
        // crypto(words, res, str, 0 , map, used)
        if (idx == str.length()) {

            int sumOfWords = 0;
            for (String s : words) {
                if(map[s.charAt(0) - 'A'] == 0)
                    return 0;
                sumOfWords += convertStringToNumber2(s, map);
            }

            int resNo = convertStringToNumber2(res, map);

            if (sumOfWords == resNo) {
                displayMap(map);
                return 1;
            }

            return 0;
        }

        int count = 0;
        char ch = str.charAt(idx);
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                map[(int) (ch - 'A')] = i;

                count += crypto(words, res, str, idx + 1, map, used);

                used[i] = false;
            }
        }
        return count;
    }

    public static boolean crypto(String[] words, String res) {
        int[] freq = new int[26];
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freq[(int) (ch - 'A')]++;
            }
        }

        for (int i = 0; i < res.length(); i++) {
            char ch = res.charAt(i);
            freq[(int) (ch - 'A')]++;
        }

        String str = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                str += (char) (i + 'A');
        }
        System.out.println(str);
        int[] map = new int[26];
        boolean[] used = new boolean[10];

        Arrays.fill(map, -1);
        // int ans =

        // for(int i = 0; i < freq.length; i++){
        // System.out.print(freq[i] + " ");
        // }
        int ans = crypto(words, res, str, 0, map, used);
        System.out.println(ans);
        // return true;
        return ans == 0 ? false : true;
    }

    public static void isSolvable(String[] words, String result) {
        System.out.println(crypto(words, result));
    }

    public static void main(String[] args) {
        // cryptoArithematic();
        String[] words = {"GEMINI","VIRGO"};
        String res = "CANCER";

        isSolvable(words, res);
    }
}
