import java.util.*;

// Question
// Take as input a number n, the number of rows
// Print the following pattern
// 0
// 1 1
// 2 3 5
// 8 13 21 34
// for n = 4.

public class pattern6 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int row = scn.nextInt();
        
        int a = 0;
        int b = 1;
        int nst = 1; // No. of star
        for (int r = 1; r <= row ; r++){
            
            for ( int cst = 1 ; cst <= nst; cst++){
                System.out.print(a + " "); 
                int temp = a;
                a = b;
                b = a + temp;
            }
            nst++;
            System.out.println();
        }
    }
}