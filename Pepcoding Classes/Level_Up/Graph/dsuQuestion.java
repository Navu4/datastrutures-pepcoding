public class dsuQuestion{

    public int findPar(int u){
    	if(par[u] == u)
    		return par[u];

    	return par[u] = findPar(par[u]);
    }

	int[] par; 
	public String smallestEquivalentString(String s1, String s2, String baseStr){

		par = new int[26];
		for(int i = 0; i < 26; i++){
			par[i] = i;
		}

		for(int i = 0; i < s1.length; i++){
			int p1 = findPar(s1.charAt(i) - 'a');
			int p2 = findPar(s2.charAt(i) - 'a');

			par[p1] = Math.min(p1, p2);
			par[p2] = Math.min(p1, p2);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < baseStr.length; i++){
			int u = baseStr.charAt(i) - 'a';
			int par = find(u);
			
			sb.append(par + 'a');
		}

		return sb.toString();
	}

	public List<Integer> numIslands2(int n, int m, Point[] operators) {


    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {


    }
}