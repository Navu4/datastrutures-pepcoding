import java.util.*;
public class question2 {
    private static int findMax(List<Integer> arr, int i, int j){
        if(i == j)
            return i;

        int mid = i + (j - i) / 2;
        if(mid == 0 && arr.get(mid) > arr.get(mid + 1))
            return mid;

        if(arr.get(i) > arr.get(mid))
            return findMax(arr, i, mid - 1);
        else    
            return findMax(arr, mid + 1, j);     
    }

    private static int findMaxElementIndex(List<Integer> arr, int arrLength) {
        int i = 0;
        int j = arr.size() - 1;

        return findMax(arr, i, j);
    }   

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scn.nextInt();
            arr.add(a);
        }
        System.out.println(findMaxElementIndex(arr, arr.size()));
    }


    private TreeNode mirror(TreeNode root){
        LinkedList<Integer> que = new LinkedList<>();
        
    }


}
