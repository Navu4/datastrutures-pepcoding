import java.util.Scanner;
import java.util.Arrays;

public class l003array{
    public static Scanner scn = new Scanner(System.in);

    // public static void arrayInput(){
    //     int[] arr = new int[10];
    //     for(int i=0; i < 20; i++){
    //         arr[i] = scn.nextInt();
    //     } 
    // }



    // Basic Question ------------------------------
    // Find the maximum value
    public static int maximumElement(int[] arr){
        int maxEle = (int)-1e8;
        for(int i= 0;i< arr.length ; i++){
            if(arr[i] > maxEle){
                maxEle = arr[i];
            }
        }
        return maxEle;
    }

    // Find the minmum value
    public static int minmumElement(int[] arr){
        int minEle = (int)1e8;
        for(int i= 0;i< arr.length ; i++){
            if(arr[i] < minEle){
                minEle = arr[i];
            }
        }
        return minEle;
    }

    // Find the entered element
    public static int findElement(int[] arr,int data){
        int idx = -1;
        for(int i= 0;i< arr.length ; i++){
            if(arr[i] == data){
                idx = i;
                break;
            }
        }
        return idx;
    }

    // Find the first index of entered element
    public static int firstIndex(int[] arr,int data){
        int idx = -1;
        for(int i= 0;i< arr.length ; i++){
            if(arr[i] == data){
                idx = i;
                break;
            }
        }
        return idx;
    }

    // Find the last index of entered element
    public static int lastIndex(int[] arr,int data){
        int idx = -1;
        for(int i= arr.length - 1;i >= 0; i--){
            if(arr[i] == data){
                idx = i;
                break;
            }
        }
        return idx;
    }

    // -----------------------------------------------------------------------------

    public static void sumOfTwoArrays(int[] arr1, int[] arr2){
        int p = arr1.length;
        int q = arr2.length;
        int r = Math.max(p,q) + 1;

        int[] arr = new int[r];

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

    public static void subOfTwoArrays(int[] arr1, int[] arr2){
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

    public static void inverse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        for(int i = 0; i < ans.length; i++){
            ans[arr[i]] = i ;
        }

        for(int ele : ans){
            System.out.println(ele + " ");
        }
    }

    // -----------------------------------------------------------------------------------------
    //  Binary Search 
    public static int binarySearch(int[] arr, int key ){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(key == arr[mid]){
                return mid;
            } else if(key < arr[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    
    // -----------------------------------------------------------------------------------------
    public static void saddlepoint(int[][] arr){
        int max = -1e9;
        int min = 1e9;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length ; j++){
                if(arr[i][j] > max) max = arr[i][j];
                if(arr[j][i] < min) min = arr[j][i];    
            }
            if(min == max) System.out.print(max);
        }
    }


    // Diagonal Traversal 
    public static void diagonalTraverse(int[][] arr){
        for(int gap = 0 ; gap < arr[0].length ; gap++){
            for(int i = 0, j = gap; i < arr.length && j < arr[0].length ; i++,j++)
                System.out.println(arr[i][j]);
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i= 0 ;i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        diagonalTraverse(arr);
    }


    public static void saddlepoint(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int r = 0; r < n ; r++){
            int c = 0;
            int minEle = (int)1e8;

            for(int j = 0; j < m ; j++){
                if(arr[r][j] < minEle){
                    minEle = arr[r][j];
                    c = j;
                }
            }

            boolean isSaddlePoint = true;

            for(int i = 0; i < n ; i++){
                if(arr[i][c] > minEle){
                    isSaddlePoint = false;
                    break;
                }
            }
            if(isSaddlePoint){
                System.out.print(minEle);
            }
        }
        System.out.print("Invalid input");
    }


    public static void searhcSortedMatrix(int[][] arr){
        int j = 0 ;
        int i = arr.length - 1;

        while(i >= 0 && j < arr.length )

            if(arr[i][j]) == data){
                System.out.print(i + "\n" + j);
                return;
            }
            else if(arr[i][j] < data){
                j++;
            }
            else{
                i--;
            }
    }

    
    public static void rotate90(int[][] arr){
        
        // Transpose
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i] ; 
                arr[j][i] = temp ; 
            }
        }
        
        int c1 = 0;
        int c2 = n -1;
        while(c1 < c2){
            
            for(int i = 0 ; i < n; i++){
                int temp = arr[i][c1];
                arr[i][c1] = arr[i][c2] ; 
                arr[i][c2] = temp ; 
            }
            c1++;
            c2--;
        } 
        
    }
    
    public static void spiralDisplay(int[][] arr){

        int n = arr.length, m = arr[0].length, count = n*m;
        int rmin = 0, rmax = n -1;
        int cmin = 0, cmax = m -1;

        while(count != 0){
            
            for(int c = rmin; c < rmax && count > 0; c++){
                System.out.println(arr[cmin],c);
                count--;
            }
            cmin++;

            for(int r = cmin; r < cmax && count > 0; r++){
                System.out.println(arr[r],rmax);
                count--;
            }
            rmax--;

            for(int c = rmax; c >= rmax && count > 0; c++){
                System.out.println(arr[cmax],c);
                count--;
            }
            cmax--;

            for(int r = cmax; r >= cmin && count > 0 ; r++){
                System.out.println(arr[r],rmax);
                count--;
            }
            rmin++;        
        }
    }

    // Rotate a shell
    public static Scanner scn = new Scanner(System.in);
    
    public static void reverse(int[] arr,int i ,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void rotate(int[] arr, int r){
        int n = arr.length;
        // if(r < 0){
        //     r = r + arr.length;
        // }
        r = (r %n + n) % n;
        // reverse(arr,0,n-1);
        // reverse(arr,0,n-r-1);
        // reverse(arr,n-r,n-1);
        reverse(arr,0,n-1);
        reverse(arr,0,r-1);
        reverse(arr,r,n-1);
    }
    
    public static int[] fillOneDfromShell(int[][] arr,int s){
        int n = arr.length;
        
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = n - s;
        int cmax = n - s;
        
        // int sz = lw + bw + rw + tw - 4 ; 
        // int sz = 2 *lw + 2 * bw - 4 ; 
        // int sz = 2 * (rmax - rmin + 1) + 2 * (cmax - cmin + 1) - 4 ; 
        int sz = 2*rmax - 2*rmin + 2*cmax - 2*cmin ; 
        
        int[] oned = new int[sz];
        
        // lw
        int idx = 0;
        for(int i = rmin , j = cmin; i <= rmax ; i++){
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // bw
        for(int i = rmax, j = cmin + 1; j <= cmax ; j++){
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // rw 
        for(int i = rmax - 1, j = cmax ; i >= rmin ; i--){
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // tw
        for(int i = rmin , j = cmax - 1 ; j >= rmin + 1 ; j--){
            oned[idx] = arr[i][j];
            idx++;
        }
        return oned;
    }
    public static void fillShellFromOneD(int[][] arr,int s,int[] oned){
        int n = arr.length;
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = n - s;
        int cmax = n - s;
        
        
        // lw
        int idx = 0;
        for(int i = rmin , j = cmin; i <= rmax ; i++){
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // bw
        for(int i = rmax, j = cmin + 1; j <= cmax ; j++){
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // rw 
        for(int i = rmax - 1, j = cmax ; i >= rmin ; i--){
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // tw
        for(int i = rmin , j = cmax - 1 ; j >= rmin + 1 ; j--){
            arr[i][j] = oned[idx];
            idx++;
        }
    }
    
    public static void shellrotate(int[][] arr,int s,int r){
        int[] oneD = fillOneDfromShell(arr,s);
        rotate(oneD,r);
        fillShellFromOneD(arr,s,oneD);
    }
    // public static void main(String[] args) throws Exception {
    //     // write your code here
    //     int n = scn.nextInt();
    //     int m = scn.nextInt();
    //     int[][] arr = new int[n][m];
    //     for(int i = 0; i < arr.length; i++){
    //         for(int j = 0; j < arr[0].length; j++){
    //             arr[i][j] = scn.nextInt(); 
    //         }
    //     }
    //     int s = scn.nextInt();
    //     int r = scn.nextInt();
        
    //     shellrotate(arr,s,r);
    //     display(arr);
    // }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}



// ------------------------------------------------------------


    public static void main(String[] args){

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length ;i++){
            arr[i] = scn.nextInt();
        } 
        
        int data = scn.nextInt();
        // System.out.print(lastIndex(arr,data));
        System.out.print(firstIndex(arr,data));
    }
}
