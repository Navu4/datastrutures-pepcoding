import java.util.*;

public class KSubsetsWithEqualSum {
    public static Scanner scn = new Scanner(System.in);

    public static void kSubsetsWithEqualSum(int[] arr, int idx, int[] totalSet, ArrayList<ArrayList<Integer>> ans) {
        if (idx == arr.length) {
            int val = totalSet[0];
            for (int i = 0; i < totalSet.length; i++) {
                if (val != totalSet[i])
                    return;
            }

            System.out.println(ans);
            return;
        }

        for (int i = 0; i < totalSet.length; i++) {

            if (totalSet[i] - arr[idx] < 0)
                continue;

            boolean isFirst = false;
            if (ans.get(i).size() == 0)
                isFirst = true;

            totalSet[i] -= arr[idx];
            ans.get(i).add(arr[idx]);

            kSubsetsWithEqualSum(arr, idx + 1, totalSet, ans);

            ans.get(i).remove(ans.get(i).size() - 1);
            totalSet[i] += arr[idx];

            if (isFirst)
                break;
        }
    }

    public static void kSubsetsWithEqualSum(int[] arr, int k) {
        int sum = 0;
        for (int ele : arr)
            sum += ele;

        if (sum % k != 0 || arr.length < k)
            return;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }

        int tar = sum / k;

        int[] totalSet = new int[k];
        Arrays.fill(totalSet, tar);

        kSubsetsWithEqualSum(arr, 0, totalSet, ans);
    }

    public static void kSubsetsWithEqualSum() {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        int k = 3;

        kSubsetsWithEqualSum(arr, k);
    }

    public static int subsetEqualSum(int[] arr, int idx, int set1, int set2, String list1, String list2) {
        if (idx == arr.length) {
            if (set1 == set2) {
                System.out.println(list1 + " = " + list2);
                return 1;
            }

            return 0;

        }

        int count = 0;
        count += subsetEqualSum(arr, idx + 1, set1 + arr[idx], set2, list1 + arr[idx] + " ", list2);
        count += subsetEqualSum(arr, idx + 1, set1, set2 + arr[idx], list1, list2 + arr[idx] + " ");

        return count;
    }

    public static void subsetEqualSum() {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };

        System.out.println(subsetEqualSum(arr, 1, 10, 0, "", ""));
    }

    public static void main(String[] args) {
        // subsetEqualSum();
        kSubsetsWithEqualSum();
    }
}