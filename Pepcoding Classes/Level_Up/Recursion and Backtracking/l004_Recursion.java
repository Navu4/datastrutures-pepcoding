public class l004_Recursion{
	
	// Two subset with equal sum
	public static int twoSubsetWithEqualSum(int[] arr, int idx, int sum1, int sum2, String set1, String set2){
		if(idx == arr.length){
			if(sum1 == sum2){
				System.out.println(set1 + " = " + set2);
				return 1;
			}

			return 0;
		}

		int count = 0;
		count += twoSubsetWithEqualSum(arr, idx + 1, sum1 + arr[idx], sum2, set1 + arr[idx] + " ", set2);
		count += twoSubsetWithEqualSum(arr, idx + 1, sum1, sum2 + arr[idx], set1, set2 + arr[idx] + " ");
		return count;
	}
	public static void twoSubsetWithEqualSum(){
		int[] arr = {10, 20, 30, 40, 50, 60};

		System.out.println(twoSubsetWithEqualSum(arr, 0, 0, 0, "", ""));
	}


	// K subset with Equal Sum
	public static void kSubsetWithEqualSum(int[] arr, int idx, int[] totalset, List<List<Integer>> ans){
		if(idx == arr.length){

			for(int i = 0; i < totalset.length; i++){
				if(totalset[i] != 0)
					return;
			}
			

			System.out.println(ans);
			return;
		}

		for(int i = 0; i < totalset.length; i++){
			if (totalSet[i] - arr[idx] < 0)
                continue;

            boolean isFirst = false;
            if (ans.get(i).size() == 0)
                isFirst = true;

			totalset[i] -= arr[i];
			ans.get(i).add(arr[i]);

			kSubsetWithEqualSum(arr, idx + 1, totalset[i] - arr[i], ans);

			ans.get(i).remove(ans.size() - 1);
			totalset[i] += arr[i];

			if(isFirst)
				break;
		}
	}

	public static void kSubsetWithEqualSum(){
		int[] arr = {10, 20, 30, 40, 50, 60};

		int n = arr.length;
		int sum = 0;
		for(int ele : arr){
			sum += ele;
		}

		int k = 3;

		int[] totalset = new int[k];
		int tar = sum / k;
		Arrays.fill(totalset, tar);

		List<List<Integer>> ans = new ArrayList<>();
		for(int i = 0; i  < k; i++){
			ans.add(new ArrayList<>());
		}


		System.out.println(kSubsetWithEqualSum(arr, 0, k, totalset, ans));
	}


	public static boolean isPalindrome(String str){
        int si = 0, ei = str.length() - 1;
        while(si <= ei){
            if(str.charAt(si++) != str.charAt(ei--)){
                return false;
            }
        }
        return true;
    }
    
	public static void AllPalindromicPartition(String str, String asf) {
	    if(str.length() == 0){
	        System.out.println(asf);
	        return;
	    }
	    
	
	    for(int i = 0; i < str.length(); i++){
	        String s = str.substring(0, i + 1);
	        if(isPalindrome(s)){
	            solution(str.substring(i + 1), asf + "(" + s + ") ");
	        }
	    }
	}


	// Friends Pairing
	public static int friendsPairing(int totalFriends, boolean[] vis, String asf){

		if(totalFriends == 0){
			System.out.println(asf);
			return 1;
		}

		int firstUnusedFriend = 0;
		for(int i = 1; i < vis.length; i++){
			if(!vis[i]){
				firstUnusedFriend = i;
				break;
			}
		}

		int count = 0;
		vis[firstUnusedFriend] = true;
		count += friendsPairing(totalFriends, vis, asf + "(" + firstUnusedFriend + ") "); // Single

		for(int i = firstUnusedFriend + 1; i < vis.length; i++){
			if(!vis[i]){
				vis[i] = true;
				count += friendsPairing(totalFriends - 2, vis, asf + "(" + firstUnusedFriend + "," + i + ") ");
				vis[i] = false;
			}
		}   

		vis[firstUnusedFriend] = false;

		return count;
	}

	public static void friendsPairing(){
		int N = 5;
		boolean[] vis = new boolean[N + 1];
	}


	// Largest Possible Number in K Swap

    public static int maxNum = 0;

    public static void swap(StringBuilder sb, int i, int j) {
        char ch1 = sb.charAt(i);
        char ch2 = sb.charAt(j);

        sb.setCharAt(i, ch2);
        sb.setCharAt(j, ch1);
    }

    public static void largestNumber(StringBuilder sb, int k) {
        if (k == 0) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < sb.length(); i++) {
            char maxCh = sb.charAt(i);
            int idx = 0;
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) > maxCh) {
                    maxCh = sb.charAt(j);
                    idx = j;
                }
            }

            if (i == idx)
                continue;

            swap(sb, i, idx);
            flag = true;
            int possibleNum = Integer.parseInt(sb.toString());
            if (possibleNum > maxNum)
                maxNum = possibleNum;

            largestNumber(sb, k - 1);

            // swap(sb, i, idx);
        }

        if (!flag)
            return;

    }

    public static void largestNumber() {
        String str = "56294137";
        int k = 4;
        largestNumber(new StringBuilder(str), k);
        System.out.println(maxNum);
    }

	public static void main(String[] args) {
		
	}
}