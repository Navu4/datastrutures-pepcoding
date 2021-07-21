import java.util.*;
public class l002string{
    public static Scanner scn = new Scanner(System.in);
    public static String consecutiveCharacter(String str){
        if(str.length() <= 1) return str;
        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            char ch = str.charAt(i);
            char ch0 = str.charAt(i-1);

            sb.append(ch - ch0);
            sb.append(ch);
        }
        return sb.toString();
    }


    public static boolean isPalindrome(String str){
        int i = 0 , j = str.length() -1 ;
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public static void palindromeSubstring(String str){
        for(int i = 0 ; i < str.length(); i++){
            for(int j = i ; j < str.length(); j++){
                String s = str.substring(i,j+1);

                if(isPalindrome(s)){
                    System.out.println(s);
                }
            }    
        }
    }

    public static String toggleString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z' ){
                sb.append((char)(ch - 'a' + 'A'));
            }
            else {
                sb.append((char)(ch - 'A' + 'a'));
            }
        }
        return sb.toString();
    }
    public static void anotherWayToPrintAllSubstrings(String str){
        for(int i = 0 ; i < str.length(); i++){
            for(int len = 1; len + i <= str.length() ; len++){
                System.out.println(str.substring( i ,i+ len));
            }
        }
    }

    // String with difference of Everytwo consecutive characters
    public static String consecutivestringdiff(String str){
		int len = str.length();
		StringBuilder ans = new StringBuilder();
		ans.append(str.charAt(0));
		
		for(int i = 1; i < len; i++){
		    char a = str.charAt(i - 1);
		    char b = str.charAt(i);
		    
		    int diff = (int)(b - a);
		    ans.append(diff);
		    ans.append(b);
		}
		
		return ans.toString() ;
	}

    // WithoutX2 problem 
    public static String withoutX2(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){

            if(i < 2 && str.charAt(i) != 'x')   sb.append(str.charAt(i));
            if(i >= 2)  sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
   
    // -------------------------------------
    // Add a character at differenet places in string
    public static ArrayList<String> appendCharInString(String str,char ch){
        ArrayList<String> sb = new ArrayList<>();
        for(int i=0; i<=str.length();i++){
            String s = str.substring(0,i) + ch + str.substring(i);
            sb.add(s);
        }
        return sb;
    }
    // ------------------------------------
    
    // permutation
    public static void appendCharInString(String str, char ch,ArrayList<String> ans){
        
        for(int i=0; i<=str.length();i++){
            String s = str.substring(0,i) + ch + str.substring(i);
            ans.add(s);
        }
    }
    public static void solution(String str) {
        // write your code here
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        for(int i = 0; i< str.length() ; i++){
            char ch = str.charAt(i);
            
            ArrayList<String> smallAns = new ArrayList<>();
            for(String s : ans){
                appendCharInString(s,ch,smallAns);
            }
            ans = smallAns;
        }
        System.out.println(ans);
    }

    // -----------------------------------

    public static boolean isPrime(int n){
        for(int i = 2;i * i <= n;i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void primeNumbers(int n,ArrayList<Integer> ans){
        for(int i = 2; i * i <= n; i++){
            if(isPrime(i)) ans.add(i);
        }
    }

    public static void primeFactors(int num,ArrayList<Integer> list){

        int idx = 0;
        while(num != 1 && idx < list.size()){
            int count = 0;
            while(num % list.get(idx) == 0){
                num /= list.get(idx);
                count++;
            }
            if(count > 0)
               System.out.print(list.get(idx) + "^" + count + " ");
            idx++;
        }
        
        if(num > 1)
            System.out.print(num + "^" + 1);
        
        System.out.println();
    }

    public static void primeFactorsForQuery(int[] query){
        ArrayList<Integer> list = new ArrayList<>();
        primeNumbers(10000,list);

        for(int ele : query){
            if(ele == 0){
                System.out.println(ele);
                continue;
            } 
            primeFactors(ele,list);
        }
    }
    
    public static void main(String[] args){
        // Scanner scn = new Scanner(System.in);
        // String str = scn.next();
        // solution(str);
        int n = scn.nextInt();  
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++) arr[i] = scn.nextInt();
        primeFactorsForQuery(arr);
    }
}