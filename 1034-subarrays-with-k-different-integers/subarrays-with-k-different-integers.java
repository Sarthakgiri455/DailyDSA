class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int greaterThanEqualsToK = atLeastKdistinctInteger(nums, k);
        int greaterThanEqualsToKplus1 = (k == nums.length ? 0 : atLeastKdistinctInteger(nums, k+1));
        return greaterThanEqualsToK - greaterThanEqualsToKplus1;

    }

    private int atLeastKdistinctInteger(int[] nums, int k) {
        int total = 0, n = nums.length;
        Map<Integer, Integer>count = new HashMap<>();
        int leftPointer = 0;
        for(int right = 0; right<nums.length; right++) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            while(count.size() >= k){   
                total = total + (n-right);
                count.put(nums[leftPointer], count.getOrDefault(nums[leftPointer], 0) - 1);
                if(count.get(nums[leftPointer]) == 0){
                    count.remove(nums[leftPointer]);
                }
                leftPointer+=1;
            }
        }
        return total;
    }
}