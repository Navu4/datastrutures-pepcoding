import java.util.ArrayList;
import java.util.Scanner;

public class diljitDosanjhGettingFamous {
    public static Scanner scn = new Scanner(System.in);

    public static void delete(ArrayList<Integer> friendList) {
        int n = friendList.size();

        boolean deleteFriend = false;
        for (int i = 0; i < friendList.size() - 1; i++) {
            if (friendList.get(i) < friendList.get(i + 1)) {
                friendList.remove(i);

                deleteFriend = true;
                break;
            }
        }
        if (deleteFriend == false)
            friendList.remove(n - 1);
    }

    public static void display(ArrayList<Integer> ans){
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = scn.nextInt();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (t-- > 0) {
            int numOfFriend = scn.nextInt();
            int deleteNum = scn.nextInt();

            ArrayList<Integer> friendList = new ArrayList<>();
            while(numOfFriend-- > 0){
                friendList.add(scn.nextInt());
            }

            while (deleteNum-- > 0) {
                delete(friendList);
            }

            ans.add(friendList);
        }
        for(ArrayList<Integer> s : ans){
            display(s);
        }
    }
}
