import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
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
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}