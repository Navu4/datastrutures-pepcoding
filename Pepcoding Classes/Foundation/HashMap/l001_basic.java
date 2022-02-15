import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class l001_basic {
    public static Scanner scn = new Scanner(System.in);

    public static void basic_01() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Nepal", 233);
        map.put("UK", 45);
        map.put("Germany", 35);
        map.put("USA", 20);
        map.put("Russia", 18);
        map.put("India", 10);
        map.put("USA", 19);

        // System.out.println(map);

        // for(String keys : map.keySet()){
        // System.out.println(keys + "->" + map.get(keys));
        // }

        // String key = "USA";
        // if (map.containsKey(key))
        // System.out.println(map.get(key));
        // else
        // System.out.println("not found");
    }

    public static void printFrequency(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < str.length(); i++) {
        // char ch = str.charAt(i);
        // if (map.containsKey(ch))
        // map.put(ch, map.get(ch) + 1);
        // else
        // map.put(ch, 1);
        // }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character keys : map.keySet()) {
            System.out.println(keys + "->" + map.get(keys));
        }
    }

    public static void highestFreqChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char ans = ' ';
        int freq = 0;
        for (Character ch : map.keySet()) {
            if (map.get(ch) > freq) {
                freq = map.get(ch);
                ans = ch;
            }
        }
        System.out.println(ans);
    }

    public static void positionOfAllChar(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        // for (int i = 0; i < str.length(); i++) {
        // char ch = str.charAt(i);
        // if (!map.containsKey(ch)){
        // map.put(ch, new ArrayList<>());
        // map.get(ch).add(i);
        // }

        // map.get(ch).add(i);

        // }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);

        }
        for (Character keys : map.keySet()) {
            System.out.println(keys + "->" + map.get(keys));
        }
    }

    public static void intersectionOfTwoArrayWithoutDuplicates(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int ele : arr2) {
            if (map.containsKey(ele)) {
                System.out.println(ele);
                map.remove(ele);
            }
        }
    }

    public static void intersectionOfTwoArrayWithDuplicates(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int ele : arr2) {
            if (map.containsKey(ele)) {
                System.out.println(ele);
                map.put(ele, map.get(ele) - 1);
                if (map.get(ele) == 0)
                    map.remove(ele);
            }
        }
    }

    public static void longestConsecutiveSequence(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int sp = 0, maxLen = 0;

        for (int ele : arr) {
            if (!map.containsKey(ele))
                continue;

            map.remove(ele);
            int le = ele - 1;
            int re = ele + 1;

            while (map.containsKey(le)) {
                map.remove(le);
                le--;
            }

            while (map.containsKey(re)) {
                map.remove(re);
                re++;
            }

            int len = re - le - 1;
            if (len > maxLen) {
                maxLen = len;
                sp = le + 1;
            }
        }

        for (int i = 0; i < maxLen; i++)
            System.out.println(sp + i);

    }

    public static void main(String[] args) {
        // String str = scn.nextLine();
        // printFrequency(str);
        // highestFreqChar(str);
        // positionOfAllChar(str);

        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }
        System.out.println("-------------------------");
        intersectionOfTwoArrayWithDuplicates(arr1, arr2);
    }
}
