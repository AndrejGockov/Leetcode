class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0)
            return 1;
        
        if(trust.length == 0)
            return -1;
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Boolean> knows = new HashMap<>();

        for(int i = 0; i < trust.length; i++){
            knows.put(trust[i][0], true);
            if(!hash.containsKey(trust[i][1])){
                hash.put(trust[i][1], 1);
            }else{
                hash.put(trust[i][1], hash.get(trust[i][1]) + 1);
            }
        }

        for(int i = 1; i <= n; i++){
            if(!knows.containsKey(i) && hash.containsKey(i) && hash.get(i) == n - 1)
                return i;
        }

        return -1;
    }
}