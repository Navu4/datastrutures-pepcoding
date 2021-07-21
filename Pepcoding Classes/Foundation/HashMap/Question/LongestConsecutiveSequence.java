class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        int maxLen = 0;
        int sp = 0;
        
        for(int ele : nums){
            if(!map.containsKey(ele))
                continue;
            
            map.remove(ele);
            int le = ele - 1;
            int re = ele + 1;
            
            while(map.containsKey(le)){
                map.remove(le);
                le--;
            }
            
            while(map.containsKey(re)){
                map.remove(re);
                re++;
            }
            
            int len = re - le - 1;
            if(len > maxLen){
                maxLen = len;
                sp = le + 1;
            }
        }
        return maxLen;
    }
}