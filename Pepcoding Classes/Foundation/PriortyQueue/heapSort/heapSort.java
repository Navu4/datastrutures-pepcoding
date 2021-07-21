import java.util.Scanner;

public class heapSort {
    public static Scanner scn = new Scanner(System.in);

    public static int compareTo(int[] arr, int a, int b) {
        if (isMax) {
            return arr[a] - arr[b];
        } else {
            return arr[b] - arr[a];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int pi, int lastIdx) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci <= lastIdx && compareTo(arr, lci, maxIdx) > 0)
            maxIdx = lci;

        if (rci <= lastIdx && compareTo(arr, rci, maxIdx) > 0)
            maxIdx = rci;

        if (pi != maxIdx) {
            swap(arr, maxIdx, pi);
            heapify(arr, maxIdx, lastIdx);
        }

    }

    public static void display(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    static boolean isMax = true;
    public static void main(String[] args) {
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        isMax = scn.nextBoolean();
        for (int i = n - 1; i >= 0; i--)
            heapify(arr, i, n - 1);

        int li = n - 1;
        while (li >= 0) {
            swap(arr, 0, li--);
            heapify(arr, 0, li);
        }

        display(arr);
    }
}
