import java.util.ArrayList;
import java.util.Scanner;


public class IndigoOrangeGame {
    public static Scanner scn = new Scanner(System.in);

    public static class pair {
        Character ch = '0';
        Integer score = 0;

        pair() {
            this.ch = '0';
            this.score = 0;
        }

        pair(Character ch, Integer score) {
            this.ch = ch;
            this.score = score;
        }

        public String toString() {
            return this.ch + " " + this.score;
        }
    }

    public static void whoWins(String board, pair p, boolean turn) {
        int n = board.length();
        if (board.length() == 1) {
            if (board.charAt(0) == 'I' && turn) {
                p.ch = 'I';
                p.score = 1;
                return;
            } else if(turn){
                p.ch = 'O';
                p.score = 2;
                return;
            } else {
                p.ch = 'O';
                p.score = 1;
                return;
            }
            
        }
        
        // if (turn) {
        //     if (board.length() == 2 || board.charAt(0) == 'I' && (board.charAt(1) == 'I' || board.charAt(n - 2) == 'O')) {
        //         whoWins(board.substring(1), p, false);
        //     } else if (board.length() == 2 || board.charAt(n - 1) == 'I') {
        //         whoWins(board.substring(0, n - 1), p, false);
        //     } else {
        //         p.ch = 'O';
        //         p.score = board.length() + 1;
        //     }
        // } else {
        //     if (board.length() == 2 || board.charAt(0) == 'O' && (board.charAt(1) == 'O' || board.charAt(n - 2) == 'O')) {
        //         whoWins(board.substring(1), p, true);
        //     } else if (board.length() == 2 || board.charAt(n - 1) == 'O') {
        //         whoWins(board.substring(0, n - 1), p, true);
        //     } else {
        //         p.ch = 'I';
        //         p.score = board.length() + 1;
        //     }
        // }
    }

    public static void main(String[] args) {
        int T = scn.nextInt();

        ArrayList<pair> ans = new ArrayList<>();
        while (T-- > 0) {
            String B = scn.next();
            pair p = new pair();
            whoWins(B, p, true);
            ans.add(p);
        }
        int idx = 1;
        for (pair ele : ans) {
            System.out.println("Case #" + idx + ": " + ele.ch + " " + ele.score);
            idx++;
        }
    }

}
