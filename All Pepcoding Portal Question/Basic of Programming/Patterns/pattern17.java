import java.util.*;

public class Main {
    public static void pattern17(int n){
        int nsp = n / 2 ;
        int nst = 1;
        
        for(int i= 0;i <= n ; i++){
            for(int j =1; j <= nsp ; j++){
                if(i == (n / 2)){
                    System.out.print("*	");
                } else {
                    System.out.print("	");
                }
            }
            
            for(int j = 1 ; j <= nst ; j++){
                System.out.print("*	");
            }
            
            if(i < n / 2){
                nst++;
            } else {
                nst--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
        pattern17(n);
    }
}