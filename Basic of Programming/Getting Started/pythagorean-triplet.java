import java.util.*;
  
  public class Main{
      public static Scanner scn = new Scanner(System.in);
      public static boolean check(int x, int y ,int z){
          int a = Math.max(x,Math.max(y,z));
          int b = 0;
          int c = 0;
          
          if(a == x){
              b = y;
              c = z;
          } else if( a == y ){
              b = x;
              c = z;
          } else if( a == z ){
              b = x;
              c = y;
          }
          
          if((a*a) == ((b*b)+(c*c))){
              return true;
          }
          else {
              return false;
          }
      }
  
  public static void main(String[] args) {
    // write your code here  
    int x = scn.nextInt();
    int y = scn.nextInt();
    int z = scn.nextInt();
    
    if(check(x,y,z)){
        System.out.println("true");
    } else {
        System.out.println("false");
    }
   }
  }