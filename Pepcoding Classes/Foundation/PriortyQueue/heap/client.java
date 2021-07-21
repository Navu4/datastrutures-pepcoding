import java.util.ArrayList;

public class client {

    public static void sovle1() {  // O(nlog(n))
        heap pq = new heap();
        for(int i= 0; i < 10; i++){ // O(nlogn)
            pq.add(i * 10);
        }

        while(pq.size() != 0){      // O(nlogn)
            System.out.println(pq.remove());
        }
    }

    public static void sovle2(int[] arr) {  // O(nlog(n))
        heap pq = new heap(arr); // O(n)

        while(pq.size() != 0){      // O(nlogn)
            System.out.println(pq.remove());
        }
    }

    public static void main(String[] args) {
        sovle1();
    }
}
