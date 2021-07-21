import java.util.*;
class Solution {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        String[] arr = new String[n];

        // Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            arr[i] = scn.next();
        }    

        int q = scn.nextInt();
        String[] query = new String[q];

        // Arrays.sort(query);
        for(int i = 0; i < n; i++){
            query[i] = scn.next();
        }

        String[] ans = solve(arr, query);
        // System.out.println(ans);
        for(String ele : ans){
            System.out.println(ans);
            if(!ele.equals(""))
                System.out.println(ele);
        }
    } 

    public static String[] solve(String[] words, String[] query){
        String[] ans = new String[query.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = "";
        }

        for(int i = 0; i < query.length; i++){
            for(int j = 0; j < words.length; j++){\

                StringBuilder smallAns = new StringBuilder();
                int idx1 = 0, idx2 = 0;
                while(idx1 < words[j].length() && idx2 < query[i].length()){
                    if(words[j].charAt(idx1))
                }



                for(int k = 0; k < query[i].length() && k < words[j].length(); k++){
                    if(words[j].charAt(k) == query[i].charAt(k)){
                        System.out.println(words[j] + " " + query[i]);
                        smallAns.append(query[i].charAt(k));
                    } 
                    else 
                        break;
                }
                if(ans[i].length() < smallAns.length())
                    ans[i] = smallAns.toString();
            }
        }
        return ans;
    }
}
