import java.util.*;

public class largestArea {

    public int[] nextSmallerOnRight(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        
        
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        
        for(int i = 0; i < n; i++){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }
            
            st.addFirst(i);
        }
        
        return ans;
    }
    
    public int[] nextSmallerOnLeft(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = n - 1; i >= 0; i--){
            while(st.size() != 0 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }
            
            st.addFirst(i);
        }
        
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        
        int[] NSOR = nextSmallerOnRight(heights);
        int[] NSOL = nextSmallerOnLeft(heights);
        
        int area = 0;
        for(int i = 0; i < len; i++){
            area = Math.max(area, (NSOR[i] - NSOL[i] - 1) * heights[i]);
        }
        
        return area;
    }
    
}
