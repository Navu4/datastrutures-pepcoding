import java.util.Scanner;

public class Main{

    public static Scanner scn = new Scanner(System.in);
    
    public static void sumOfTwoArrays(int[] arr1, int[] arr2){
        int p = arr1.length;
        int q = arr2.length;
        int r = p;

        int[] ans = new int[r];

        int borrow = 0 ;
        int i = p -1;
        int j = q -1;
        int k = r -1;


        while(k >= 0){
            int num = borrow;
            if(i >= 0){
                num += arr1[i--];
            }    
            if(j >= 0){
                num -= arr2[j--]; // Subtract
            }    
            
            if(num < 0){
                num += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }
            ans[k--] = num;
        }
        boolean flag = false;
        for(int l = 0; l < ans.length ; l++){
            if( !flag && ans[l] == 0){
                continue;
            } 
            flag = true;
            System.out.println(ans[l]);
        }
    }

    public static void main(String[] args) {
        // write your code here
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i< arr1.length ; i++){
            arr1[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i< arr2.length ; i++){
            arr2[i] = scn.nextInt();
        }
        
        sumOfTwoArrays(arr2,arr1);
    }

}