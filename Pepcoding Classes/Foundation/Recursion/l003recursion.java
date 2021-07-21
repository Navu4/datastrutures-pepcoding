import java.util.Scanner;
import java.util.ArrayList;

public class l003recursion{
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scn.next();
        
        System.out.println(gss(str,0));
    }



    // IMPORTANT QUESTION   
    // Mobile KeyPad Problem 
    // 0 -> .;
    // 1 -> abc
    // 2 -> def
    // 3 -> ghi
    // 4 -> jkl
    // 5 -> mno
    // 6 -> pqrs
    // 7 -> tu
    // 8 -> vwx
    // 9 -> yz
    
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList < String > getKPC(String str, int idx) {
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> recAns = getKPC(str,idx + 1);
        ArrayList<String> myAns = new ArrayList<>();
        
        char ch = str.charAt(idx);
        ArrayList<String> ans = new ArrayList<>();
        
        String code = codes[ch - '0'];
        for(int i = 0; i < code.length() ; i++){
            char c = code.charAt(i);
            
            for(String s : recAns){
                myAns.add(c + s);
            }
        }

        return myAns;
    }

// ===================================================================================

    // Get Subsequence of a String 
    // Example :- 
    // Input : "abc"
    // Output : [, c, b, bc, a, ac, ab, abc]

    public static ArrayList < String > gss(String str, int idx) {  
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(idx);
        
        ArrayList<String> recAns = gss(str, idx +1);
        ArrayList<String> myAns = new ArrayList<>(recAns);
        
        for (String s : recAns){
            myAns.add(ch + s);
        }
        
        
        return myAns;
    }

    // ALL TYPES OF SUBSEQUENCE USING RETURN TYPE & WAY UP 
    public static void printSS(String str, int idx, String ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        printSS(str, idx + 1, ans + str.charAt(idx));
        printSS(str, idx + 1, ans);
    }

    public static void printSS_02(String str, int idx, StringBuilder ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        ans.append(str.charAt(idx));
        printSS_02(str, idx + 1, ans);
        ans.deleteCharAt(ans.length() - 1);

        printSS_02(str, idx + 1, ans);
    }

    // return Type
    public static ArrayList<String> subseq_03(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = subseq_03(str, idx + 1);

        ArrayList<String> myAns = new ArrayList<>(recAns); // nahi anne ki choise dekhli.

        char ch = str.charAt(idx);
        for (String s : recAns) {
            myAns.add(ch + s);
        }

        return myAns;
    }

    public static void printASCIISS(String str, int idx, String ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        printASCIISS(str, idx + 1, ans + str.charAt(idx));
        printASCIISS(str, idx + 1, ans + (int) str.charAt(idx));
        printASCIISS(str, idx + 1, ans);
    }

    public static ArrayList<String> printASCIISS_Ret(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = printASCIISS_Ret(str, idx + 1);

        ArrayList<String> myAns = new ArrayList<>(); // nahi anne ki choise dekhli.

        char ch = str.charAt(idx);
        for (String s : recAns) {
            myAns.add(ch + s);
            myAns.add((int) ch + s);
            myAns.add(s);
        }

        return myAns;
    }

}