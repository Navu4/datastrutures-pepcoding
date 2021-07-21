import java.util.Scanner;
import java.util.ArrayList;

public class l002backtracking{
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args){
        int[] arr = {30,10,20};
        // System.out.println(equiSet(arr, 0, 0, 0, "", ""));
        System.out.println(equiSet(arr, 1, arr[0], 0, arr[0] + " ", ""));
    }


    // ---------------------------------------------------------------------------

    // Target Sum
    // This is a functional problem. Only this function has to be written.
    // This function takes as an integer array and an integer
    // It should return the required output
    
    public static int findCountOfTargetSum(int[] nums, int S, int idx){
        if(idx == nums.length){
            if(S == 0){
                return 1;
            }
            return 0;
        }
        
        int count = 0 ;
        count += findCountOfTargetSum(nums,S - nums[idx],idx + 1);
        count += findCountOfTargetSum(nums,S - (-nums[idx]),idx + 1);
        
        return count;
    }

    // -------------------------------------------------------------------------------------


    // SET QUESTION
    // S = {......................}
    // A & B subset of S 
    // A = {.............}
    // B = {..........}

    // 1. A U B = S
    // 2. A intersection B = 0
    // 3. Sum of A = Sum of B

    // Sum of Two Array Should be Equals( SET ) 

    public static int equiSet(int[] arr, int idx, int sum1, int sum2, String set1, String set2){

        if(idx == arr.length){
            if(sum1 == sum2){
                System.out.println(set1 + "= " + set2);
                return 1;
            }
            return 0;
        }

        int count = 0 ;
        count += equiSet(arr,idx + 1, sum1 + arr[idx], sum2, set1 + arr[idx] + " ", set2);
        count += equiSet(arr,idx + 1, sum1, sum2 + arr[idx], set1, set2 + arr[idx] + " ");

        return count;
    }
}