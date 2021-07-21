import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    
    public static ArrayList<String> getMazePaths_multiMoves(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for (int jump = 1; sc + jump <= dc; jump++) {
            ArrayList<String> Horizontal = getMazePaths_multiMoves(sr, sc + jump, dr, dc);
            for (String s : Horizontal) {
                myAns.add("H" + jump + s);
            }
        }

        for (int jump = 1; sr + jump <= dr; jump++) {
            ArrayList<String> Vertical = getMazePaths_multiMoves(sr + jump, sc, dr, dc);
            for (String s : Vertical) {
                myAns.add("V" + jump + s);
            }
        }

        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            ArrayList<String> Digonal = getMazePaths_multiMoves(sr + jump, sc + jump, dr, dc);
            for (String s : Digonal) {
                myAns.add("D" + jump + s);
            }
        }

        return myAns;
    }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        ArrayList<String> ans = getMazePaths_multiMoves(0, 0, n - 1,m - 1);
        
        System.out.println(ans.size());
        System.out.println(ans);
        
        for(String s: ans){
            System.out.println(s);
        }
    }
}