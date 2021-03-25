import java.util.*;
  
  public class Main{
  public static Scanner scn = new Scanner(System.in);
  public static void curiouscaseOfBenjamin(int n){
      for( int i = 1 ; i*i < n ;i++){
          System.out.println(i*i);
      }
  }
  public static void main(String[] args) {
    // write your code here  
    int n = scn.nextInt();
    
    curiouscaseOfBenjamin(n);
   }
  }