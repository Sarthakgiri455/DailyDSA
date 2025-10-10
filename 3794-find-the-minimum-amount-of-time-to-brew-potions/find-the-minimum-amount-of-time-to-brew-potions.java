class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[]dp = new long[skill.length+1];
        
        for(int i=0; i < mana.length;i++) {
            for(int j =0;j<skill.length;j++) {
                long currentTime = (long)skill[j]*mana[i];
                dp[j+1] = Math.max(dp[j-1+1], dp[j+1]) + currentTime;
            }
            for(int j = dp.length-2; j>=1; j--){
                dp[j] = dp[j+1] - (long)skill[j]*mana[i];
            }
        }
        return dp[skill.length];
        // ith potion -> jth person
        // jth person ->i-1 potion
        // ith potion -> j-1th person
        
    }
}