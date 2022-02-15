import java.util.Scanner;
    
    public class Main{
        
    public static Scanner scn = new Scanner(System.in);
    
    public static int countDigit(int n){
        int count = 0 ;
        int num = n;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }
    
    public static void printDigits(int n){
            int len = countDigit(n);
            
            int div = 1;
            while(len-- > 1){
                div *= 10;
            }
            
            while(div !=0){
                System.out.println(n/div);
                n = n %div ;
                div /= 10;
            }
    } 
    
    public static void main(String[] args) {
      // write your code here  
        int n = scn.nextInt();

        printDigits(n);
     }
    }