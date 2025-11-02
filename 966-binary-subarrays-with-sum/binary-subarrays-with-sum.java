class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {


     int val1 = getSubArraySumLessThanGoal(nums, goal);   
     int val2 = getSubArraySumLessThanGoal(nums, goal-1);  
     return  val1-val2;
    }

    private int getSubArraySumLessThanGoal(int[]nums, int goal) {

        int sum = 0;
        int left = 0;
        int ans = 0;
        if(goal<0){
            return 0;
        }
        for(int right = 0; right<nums.length;right++) {
            sum = sum + nums[right];
            while(sum>goal){
                sum = sum - nums[left];
                left+=1;
            }
            ans = ans + (right-left+1);
        }
        return ans;
    }
}