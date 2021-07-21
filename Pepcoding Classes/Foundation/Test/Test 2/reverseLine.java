import java.util.Scanner;
import java.util.Stack;

public class reverseLine {
    public static Scanner scn = new Scanner(System.in);

    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));         
            } else if(sb.length() >= 1){
                st.push(sb.toString());
                sb = new StringBuilder();
            } else {
                continue;
            }
        }
        if(sb.length() > 0){
            st.push(sb.toString());
        }
        StringBuilder ans = new StringBuilder();
        while(st.size() != 0){
            String str = st.pop();
            ans.append(str);
            if(st.size() == 0){
                break;
            }
            ans.append(" ");
        }
        
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = scn.nextLine();
        // System.out.println(s.length());
        System.out.println(reverseWords(s));
    }
}
