import java.util.*;

public class question {

    // rearrage Positive and negative values in an Array
    public static void rearrange_alternate_positions(int arr[], int n) {
        int temp, j;
        for (int i = 1; i < n; i++) {
            temp = arr[i];
            if (temp > 0)
                continue;

            j = i - 1;
            while (arr[j] > 0 && j >= 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // 39
    public int combinationSum(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum(arr, tar - arr[i], i, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }

        return count;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum(candidates, target, 0, smallAns, res);

        return res;
    }

    // 40
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        boolean[] vis = new boolean[51];
        for (int i = idx; i < arr.length; i++) {
            if (!vis[arr[i]] && tar - arr[i] >= 0) {

                vis[arr[i]] = true;

                smallAns.add(arr[i]);
                count += combinationSum2(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }

        return count;
    }

    public int combinationSum2_01(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        int prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (prev != arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum2_01(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }

            if (tar - arr[i] < 0)
                break;

            prev = arr[i];
        }

        return count;
    }

    // Using Subsequence Method
    public int combinationSum2_03(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            count += combinationSum2_03(arr, tar - arr[idx], idx + 1, smallAns, res);
            smallAns.remove(smallAns.size() - 1);
        }

        idx++;
        while (idx < arr.length && arr[idx - 1] == arr[idx]) {
            idx++;
        }

        count += combinationSum2_03(arr, tar, idx, smallAns, res);
        return count;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2(candidates, target, 0, smallAns, res);

        return res;
    }

    // 77
    public int combine(int n, int k, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (k == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = idx; i <= n; i++) {
            smallAns.add(i);
            count += combine(n, k - 1, i + 1, smallAns, res);
            smallAns.remove(smallAns.size() - 1);
        }

        return count;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combine(n, k, 1, smallAns, res);

        return res;
    }

    // 216
    public int combinationSum3(int tar, int k, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (k == 0 || tar == 0) {
            if (tar == 0 && k == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i <= 9; i++) {
            if (tar - i >= 0) {
                smallAns.add(i);
                count += combinationSum3(tar - i, k - 1, i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            } else
                break;
        }

        return count;
    }

    public List<List<Integer>> combinationSum3(int k, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum3(tar, k, 1, smallAns, res);

        return res;
    }

    // 46

    // tel = total no of elements.
    public int permute(int[] arr, int tel, List<Integer> smallAns, List<List<Integer>> res) {
        if (tel == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -11) { // -11, as per constraints.
                int val = arr[i];
                arr[i] = -11;
                smallAns.add(val);

                count += permute(arr, tel - 1, smallAns, res);

                smallAns.remove(smallAns.size() - 1);
                arr[i] = val;
            }
        }
        return count;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        permute(nums, nums.length, smallAns, res);

        return res;
    }

    // 47
    public int permuteUnique(int[] arr, int tel, List<Integer> smallAns, List<List<Integer>> res) {
        if (tel == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        int prev = -12;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -11 && prev != arr[i]) { // -11, as per constraints.
                int val = arr[i];
                arr[i] = -11;
                smallAns.add(val);

                count += permuteUnique(arr, tel - 1, smallAns, res);

                smallAns.remove(smallAns.size() - 1);
                arr[i] = val;

                prev = arr[i];
            }
        }
        return count;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        Arrays.sort(nums);
        permuteUnique(nums, nums.length, smallAns, res);

        return res;
    }
}
