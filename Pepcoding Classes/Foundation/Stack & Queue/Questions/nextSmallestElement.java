import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class nextSmallestElement {
    public static Scanner scn = new Scanner(System.in);

    public static int[] solve(int[] arr) {
        int n = arr.length;

        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while(st.size() != 0 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = arr[i];
            }

            st.addFirst(i);
        }
        
        return ans;
    }

    

    public static void main(String[] args) {
        int n = scn.nextInt();

        int[] arr= new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int[] ans = solve(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
