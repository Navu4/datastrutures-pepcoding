import java.util.Stack;
import java.util.Scanner;
public class aliceLibrary {
    public static Scanner scn = new Scanner(System.in);

    public static String alicesLibrary(String str){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '\\'){
                st.push(str.charAt(i));
                continue;
            }

            while(st.peek() != '/'){
                ans.append(st.pop());
            }

            st.pop();
            while(ans.length() > 0){
                char ch = ans.charAt(0);
                ans.deleteCharAt(0);
                st.push(ch);
            }
        }   

        while(st.size() != 0){
            ans.append(st.pop());
        }     

        return ans.reverse().toString();
    }

    public static void main(String args[] ) throws Exception {
        
        String str = scn.nextLine();
        

        System.out.println(alicesLibrary(str));
    }
}
