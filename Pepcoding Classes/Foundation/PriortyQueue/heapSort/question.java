import java.util.Scanner;

public class question {
    public static Scanner scn = new Scanner(System.in);

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int pi, int lastIdx) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci <= lastIdx && arr[lci] > arr[maxIdx])
            maxIdx = lci;

        if (rci <= lastIdx && arr[rci] > arr[maxIdx])
            maxIdx = rci;

        if (pi != maxIdx) {
            swap(arr, maxIdx, pi);
            heapify(arr, maxIdx, lastIdx);
        }

    }
    
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--){
            heapify(nums, i, n - 1);
        }
        
        int li = n - 1;
        while (li >= 0 && k-- > 0) {
            swap(nums, 0, li--);
            heapify(nums, 0, li);
        }
        return nums[li + 1];
        
    }


    public int kthSmallesT(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return matrix[a / m][a % m] - matrix[b / m][b % m];
        });

        for (int i = 0; i < n; i++)
            pq.add(i * m + 0);

        int r = 0;
        int c = 0;

        while (--k > 0) {
            int idx = pq.remove();
            r = idx / m;
            c = idx % m + 1;
            if (c < m)
                pq.add(r * m + c);
        }

        return matrix[r][c];
    }

    // 378
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return matrix[a / m][a % m] - matrix[b / m][b % m];
        });

        for (int i = 0; i < n; i++)
            pq.add(i * m + 0);

        while (--k > 0) {
            int idx = pq.remove();
            int r = idx / m;
            int c = (idx % m);
            if (c + 1 < m)
                pq.add(r * m + c + 1);
        }

        int idx = pq.peek();
        return matrix[idx / m][idx % m];
    }

    public static void main(String[] args) {
        int n = scn.nextInt();

        int[] arr= new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int ans = findKthLargest(arr, k);
        System.out.println(ans);
    }
}
