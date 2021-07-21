import java.util.HashMap;
import java.util.Scanner;
public class client {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap map = new HashMap();    
        for (int i = 0; i < 10; i++) {
            map.put(i, i * 100);
        }
        System.out.println(map.get(11));
        // System.out.println(map);
    }
}
