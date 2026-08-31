
class Solution {
    public int minOperations(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Process each element of nums EXACTLY ONCE
        for (int x : nums) {
            // 1. Gather all (value, minCost) pairs reachable from x
            Map<Integer, Integer> valueToMinCost = new HashMap<>();

            // Repeatedly divide (down to 1)
            int temp = x;
            int cost = 0;
            while (temp > 0) {
                if (temp <= sum) {
                    valueToMinCost.put(temp,cost);
                }
                temp /= 2;
                cost++;
            }

            // Double x zero or more times, then repeatedly divide
            
            int multCost = 1;
            long mult = x*2;
            while (mult <= sum) {
                long divTemp = mult;
                int divCost = multCost;

                valueToMinCost.put((int)divTemp, divCost);
                    

                mult *= 2;
                multCost++;
            }

            // 2. 0/1 Knapsack transition: update DP array backwards
            int[] nextDp = dp.clone();
            for (Map.Entry<Integer, Integer> entry : valueToMinCost.entrySet()) {
                int val = entry.getKey();
                int c = entry.getValue();

                for (int s = sum; s >= val; s--) {
                    if (dp[s - val] != Integer.MAX_VALUE) {
                        nextDp[s] = Math.min(nextDp[s], dp[s - val] + c);
                    }
                }
            }
            dp = nextDp;
        }

        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}