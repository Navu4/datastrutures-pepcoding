import java.util.*;

public class hackerrankcrossWordPuzzle {
    public static Scanner scn = new Scanner(System.in);

    public static boolean isSafeToPlaceWordH(List<String> box, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {
            if (c + i >= box.get(0).length())
                return false;
            if (box.get(r).charAt(c + i) != '-' && box.get(r).charAt(c + i) != word.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean[] placeH(List<String> box, String word, int r, int c) {
        boolean[] loc = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (box.get(r).charAt(c + i) == '-') {
                String str = box.get(r);
                char ch = word.charAt(i);
                str = str.substring(0, c + i) + ch + str.substring(c + i + 1);
                box.set(r, str);
                loc[i] = true;
            }
        }
        return loc;
    }

    public static void unplaceH(List<String> box, String word, int r, int c, boolean[] loc) {

        for (int i = 0; i < word.length(); i++) {
            if (loc[i]) {
                char ch = '-';
                String str = box.get(r);
                str = str.substring(0, c + i) + ch + str.substring(c + i + 1);
                box.set(r, str);
            }
        }
    }

    public static boolean isSafeToPlaceWordV(List<String> box, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {
            if (r + i >= box.size())
                return false;
            if (box.get(r + i).charAt(c) != '-' && box.get(r + i).charAt(c) != word.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean[] placeV(List<String> box, String word, int r, int c) {
        boolean[] loc = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (box.get(r + i).charAt(c) == '-') {
                String str = box.get(r + i);
                char ch = word.charAt(i);
                str = str.substring(0, c) + ch + str.substring(c + 1);
                box.set(r + i, str);
                loc[i] = true;
            }
        }
        return loc;
    }

    public static void unplaceV(List<String> box, String word, int r, int c, boolean[] loc) {
        for (int i = 0; i < word.length(); i++) {
            if (loc[i]) {
                char ch = '-';
                String str = box.get(r + i);
                str = str.substring(0, c) + ch + str.substring(c + 1);
                box.set(r + i, str);
            }
        }

    }

    public static boolean crossWordPuzzle(List<String> box, String[] words, int idx) {
        if (idx == words.length) {
            // print2D(box);
            return true;
        }

        String word = words[idx];
        int n = box.size();
        int m = box.get(0).length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box.get(i).charAt(j) == '-' || box.get(i).charAt(j) == word.charAt(0)) {
                    if (isSafeToPlaceWordH(box, word, i, j)) {
                        boolean[] loc = placeH(box, word, i, j);
                        if (crossWordPuzzle(box, words, idx + 1))
                            return true;
                        unplaceH(box, word, i, j, loc);
                    }

                    if (isSafeToPlaceWordV(box, word, i, j)) {
                        boolean[] loc = placeV(box, word, i, j);
                        if (crossWordPuzzle(box, words, idx + 1))
                            return true;
                        unplaceV(box, word, i, j, loc);
                    }
                }
            }
        }
        return false;
    }

    public static void print2D(List<String> box) {
        int n = box.size(), m = box.get(0).length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(box.get(i).charAt(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {

        int idx = 0;
        String[] wordsList = words.split(";");
        Arrays.sort(wordsList, (a, b) -> {
            return b.length() - a.length();
        });

        crossWordPuzzle(crossword, wordsList, idx);
        return crossword;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        List<String> crossword = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scn.next();
            crossword.add(s);
        }

         
        String words = "POLAND;LHASA;SPAIN;INDIA";
        // System.out.println("======================================");
        // for (String s : crossword) {
        //     System.out.println(s );
        // }
        String[] wordList = words.split(";");
        // for (String s : wordList) {
        //         System.out.println(s);
        // }
        //     String word = "agra";
        // boolean res = isSafeToPlaceWordV(crossword, word, 0, 1);
        // if(res){
        //     boolean[] loc = placeV(crossword, word, 0, 1);
        //     for (String s : crossword) {
        //         System.out.println(s);
        //     }
        //     unplaceV(crossword, word, 0, 1, loc);
        // }
        // for (String s : crossword) {
        //     System.out.println(s);
        // }
        crosswordPuzzle(crossword, words));
    }
}
