import java.util.*;
public class l002star{

    // *
    // **
    // ***
    // ****
    // *****
    public static void printTriangle(int row){
        int nst = 1; // No. of star
        for (int r = 1; r <= row ; r++){
            for ( int cst = 1 ; cst <= nst; cst++){
                System.out.println("*\t"); 
            }
            nst++;
            System.out.println();
        }
    }
    public static void pattern2(int row){
        int nst = 1; // No. of star
        for (int r = 1; r <= row ; r++){
            for ( int cst = 1 ; cst <= nst; cst++){
                System.out.println("*\t"); 
            }
            nst--;
            System.out.println();
        }
    }

    public static void printMirrorTriangle(int row){
        int nst = 1; // No. of star
        int nsp = row -1; //No. of space
        for (int r = 1; r <= row ; r++){
            for( int csp = 1; csp <= nsp; csp++){
                System.out.print(" ");
            }

            for ( int cst = 1 ; cst <= nst; cst++){
                System.out.print("*"); 
            }
            nsp--;
            nst += 2;
            System.out.print();
        }
    }

    public static void pattern16(int n){
        int sp = 2* n -3;
        int st = 1;

        for( int i = 1; i <= n; i++){
            for( int j = 1; j <= st; j++){
                System.out.print("*\t");
            }

            for( int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            if(i == n){
                st--;
            }
            for( int j = 1; j <= st; j++){
                System.out.print("*\t");
            }

            st++;
            sp -= 2;
            System.out.println();
        }

    }

    public static void pattern17(int n){
        int nsp = n / 2 ;
        int nst = 1;
        
        for(int i= 0;i <= n ; i++){
            for(int j =1; j <= nsp ; j++){
                if(i == (n / 2)){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            
            for(int j = 1 ; j <= nst ; j++){
                System.out.print("*\t");
            }
            
            if(i < n / 2){
                nst++;
            } else {
                nst--;
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern16(n);
    }
}