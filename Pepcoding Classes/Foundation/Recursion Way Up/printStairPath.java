import java.util.*;

public class printStairPaths {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        
        printStairPaths(n, 0, "");
    }

    public static void printStairPaths(int n, int idx, String ans) {
        if(idx == n){
            System.out.println(ans);
            return ;
        }
        
        for(int jumps = 1; jumps <= 3; jumps++){
            if(idx + jumps <= n){
                printStairPaths(n, idx + jumps, ans + jumps);
            }
        }
        return;
    }

}