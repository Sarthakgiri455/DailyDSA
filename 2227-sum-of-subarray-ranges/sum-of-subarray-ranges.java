class Solution {
    public long subArrayRanges(int[] nums) {
        long sumOfMinimum = calculateSumOfMinimumOfAllSubArrays(nums);
        long sumOfMaximum = calculateSumOfMaximumOfAllSubArrays(nums);
        return sumOfMaximum - sumOfMinimum;
    }
    
    private long calculateSumOfMinimumOfAllSubArrays(int[]nums) {
        Stack<Integer> nSEStack = new Stack<>();
        long[]nSEArray = new long[nums.length];
        Stack<Integer> pSEStack = new Stack<>();
        long[]pSEArray = new long[nums.length];
        pSEStack.push(-1);
        nSEStack.push(nums.length);
        for(int i = 0; i<nums.length; i++) {
            while(!pSEStack.isEmpty() && pSEStack.peek() != -1 && nums[pSEStack.peek()] >= nums[i]) {
                pSEStack.pop();
            }
            pSEArray[i] = i - pSEStack.peek();
            pSEStack.push(i);
        }
        for(int i = nums.length - 1; i>=0; i--) {
            while(!nSEStack.isEmpty() && nSEStack.peek() != nums.length && nums[nSEStack.peek()] > nums[i]) {
                nSEStack.pop();
            }
            nSEArray[i] =  nSEStack.peek() -i;
            nSEStack.push(i);
        }
        long ans = 0;
        for(int i = 0; i < nums.length;i++) {
            ans = ans + (pSEArray[i] * nSEArray[i] * nums[i]);
        }
        return ans; 
    }

        private long calculateSumOfMaximumOfAllSubArrays(int[]nums) {
        Stack<Integer> nLEStack = new Stack<>();
        long[]nLEArray = new long[nums.length];
        Stack<Integer> pLEStack = new Stack<>();
        long[]pLEArray = new long[nums.length];
        pLEStack.push(-1);
        nLEStack.push(nums.length);
        for(int i = 0; i<nums.length; i++) {
            while(!pLEStack.isEmpty() && pLEStack.peek() != -1 && nums[pLEStack.peek()] <= nums[i]) {
                pLEStack.pop();
            }
            pLEArray[i] = i - pLEStack.peek();
            pLEStack.push(i);
        }
        for(int i = nums.length - 1; i>=0; i--) {
            while(!nLEStack.isEmpty() && nLEStack.peek() != nums.length && nums[nLEStack.peek()] < nums[i]) {
                nLEStack.pop();
            }
            nLEArray[i] =  nLEStack.peek() -i;
            nLEStack.push(i);
        }
        long ans = 0;
        for(int i = 0; i < nums.length;i++) {
            ans = ans + (pLEArray[i] * nLEArray[i] * nums[i]);
        }
        return ans; 
    }
}