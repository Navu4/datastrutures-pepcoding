import java.io.*;
import java.util.*;

public class intersectionOfTwoArrayWithoutDuplicates {

    public static Scanner scn = new Scanner(System.in);

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

    public static void main(String[] args) throws Exception {
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

        intersectionOfTwoArrayWithoutDuplicates(arr1, arr2);
    }

}