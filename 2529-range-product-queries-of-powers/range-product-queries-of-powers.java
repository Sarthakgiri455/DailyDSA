class Solution {
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer>powersOfTwo = new ArrayList<Integer>();
        int step = 0;
        while(n>0){
            int remainder = n&1;
            if(remainder!=0){
                powersOfTwo.add((int)Math.pow(2, step));
            }
            step+=1;
            n/=2;
        }
        int[] answer = new int[queries.length];
        
        int querycount = 0;
        for(int[] query : queries){
            int left = query[0];
            int right = query[1];
            long res = (long)1;
            for(int k = left;k<=right;k++){
                res = (powersOfTwo.get(k) * res) % (1000000007);
            }
            answer[querycount] = (int)res;
            querycount+=1;
        }
        return answer;
    }
}