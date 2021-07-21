import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class petTreat {
    public static Scanner scn = new Scanner(System.in);

    public static int petTreats(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int noOfTreats = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // System.out.println(map);

        int noOfmap = map.size();
        int[] ans = new int[noOfmap];

        int idx = 0;
        for (Integer keys : map.keySet()) {
            ans[idx] = keys;
            idx++;
        }
        Arrays.sort(ans);
        int val = 1;
        for (int i = 0; i < ans.length; i++) {
            int count = map.get(ans[i]);
            noOfTreats += count * val;
            val++;
        }

        return noOfTreats;
    }

    public static void main(String[] args) {
        int T = scn.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        while (T-- > 0) {
            int N = scn.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scn.nextInt();
            }
            int noOfTreats = petTreats(arr);
            ans.add(noOfTreats);
        }
        int i = 1;
        for (Integer ele : ans) {
            System.out.println("Case #" + i + ": " + ele);
            i++;
        }
    }
}
