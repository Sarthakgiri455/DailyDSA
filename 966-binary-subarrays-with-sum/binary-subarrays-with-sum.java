class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int currentCount = 0;
        HashMap<Integer, Integer>sumCount = new HashMap<>();
        int sum = 0;
        int ans = 0;
        sumCount.put(0, 1);
        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
                       

            int prevSum = sumCount.getOrDefault(sum-goal, 0);
             sumCount.put(sum, sumCount.getOrDefault(sum, 0)+1);
            ans = ans + prevSum;
        }
        return ans;
    }
}