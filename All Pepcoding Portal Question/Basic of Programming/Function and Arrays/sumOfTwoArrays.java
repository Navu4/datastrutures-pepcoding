import java.util.*;
import java.util.Scanner;

public class Main{

    public static Scanner scn = new Scanner(System.in);
    
    public static void sumOfTwoArrays(int[] arr1, int[] arr2){
        int p = arr1.length;
        int q = arr2.length;
        int r = ((p>q)?p:q) + 1;

        int[] ans = new int[r];

        int carry = 0 ;
        int i = p -1;
        int j = q -1;
        int k = r -1;


        while(k >= 0){
            int sum = carry;
            if(i >= 0){
                sum += arr1[i--];
            }    
            if(j >= 0){
                sum += arr2[j--];
            }    

            ans[k--] = sum % 10;
            carry = sum / 10;
        }

        for(int l = 0; l < ans.length ; l++){
            if( l == 0 && ans[l] == 0){
                continue;
            } 
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
        
        sumOfTwoArrays(arr1,arr2);
    }

}