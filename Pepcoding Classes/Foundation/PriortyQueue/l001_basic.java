import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;

public class l001_basic{
    public static Scanner scn = new Scanner(System.in);

    public static void MinPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 10; i >= 0; i--){
            pq.add(i);  // Add values in priority queue => O(log(n))
        }

        while(pq.size() != 0){      // size function return size of PQ => O(1)
            int ele = pq.remove();   // Remove function => O(log(n))
            System.out.print(ele + " ");
        }

    }


    public static void MaxPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            // return a - b; // this - other, default behaviour.
            return b - a; // other - this, reverse of default.
        });
        for(int i = 10; i >= 0; i--){
            pq.add(i);  // Add values in priority queue
        }

        while(pq.size() != 0){
            int ele = pq.remove();
            System.out.print(ele + " ");
        }

    }

    public static void kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele : arr){
            pq.add(ele);

            if(pq.size() > k){
                pq.remove();
            }
        }

        while (pq.size() != 0) {
            System.out.println(pq.remove());
        }
    }

    public static void kSmallestElemets(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b - a;
        });

        for(int ele : arr){
            pq.add(ele);

            if(pq.size() > k){
                pq.remove();
            }
        }

        while (pq.size() != 0) {
            System.out.println(pq.remove());
        }
    }

    // 347. Top K Frequent Elements
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        // {val, freq}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
            
        for(Integer e : map.keySet()){
            pq.add(new int[]{e, map.get(e)});
            
            if(pq.size() > k){
                pq.remove();
            }
        } 
        
        int[] ans = new int[k];
        int idx = 0;
        while(pq.size() != 0){
            ans[idx++] = pq.remove()[0];
        }
        
        return ans;
    }

    // OR
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        // {val, freq}
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return  map.get(a) - map.get(b);
        });
            
        for(Integer e : map.keySet()){
            pq.add(e);
            
            if(pq.size() > k){
                pq.remove();
            }
        } 
        
        int[] ans = new int[k];
        int idx = 0;
        while(pq.size() != 0){
            ans[idx++] = pq.remove();
        }
        
        return ans;
    }


    // 692. Top K Frequent Words
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b)->{
            if (map.get(a) == map.get(b)) {
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });
        
        for(String word : map.keySet()){
            pq.add(word);
            
            if(pq.size() > k){
                pq.remove();
            }
        }   
           
        List<String> ans = new ArrayList<>();
        while(pq.size() != 0){
            ans.add(pq.remove());
        }

        Collections.sort(ans, (a,b)->{    // Sort the list (ArrayList)
            if(map.get(a) == map.get(b)){
                return b.compareTo(a);  // Lexographical comparision
            } else {
                return map.get(b) - map.get(a);
            }
        })

        return ans;
    }
        // OR
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });

        for (String word : map.keySet()) {
            pq.add(word);
            if (pq.size() > k)
                pq.remove();
        }

        int idx = pq.size();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < idx; i++)
            ans.add("");
        while (pq.size() != 0) {
            ans.set(--idx, pq.remove());
        }

        return ans;
    }


    public static void main(String[] args) {
        // MinPQ();
        // System.out.println();
        // MaxPQ();

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        // kLargest(arr, k);
        int[] ans = topKFrequent2(arr, k);
        for(int i = 0 ; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

// -----------------------
