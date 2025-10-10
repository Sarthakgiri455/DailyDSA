class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[][]dp = new int[energy.length][2];
        for(int[]row: dp) {
            Arrays.fill(row, -1);
        }
        return recursion(dp, 0, 0, k, energy, 0);
    }
    private int recursion(int[][]dp, int index, int choice, int k, int[]energy, int count) {
        if(index>=dp.length && count ==0) {
            return Integer.MIN_VALUE;
        }
        if(index>=dp.length){
            return 0;
        }
        if(dp[index][choice]!= -1) 
        {
            return dp[index][choice];
        }
        int ans = energy[index] + recursion(dp, index+k, 1, k, energy, count+1);
        if(choice==0){
            ans = Math.max(ans, recursion(dp, index+1, choice, k, energy, count));
        }
        return dp[index][choice] = ans;
    }

}