class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>nextGreaterStoreStack = new Stack<Integer>();
        for(int i = nums.length -1; i>=0; i--) {
            nextGreaterStoreStack.push(nums[i]);
        }
        int[]ans = new int[nums.length];
        for(int i = nums.length - 1; i>=0; i--) {
            while(!nextGreaterStoreStack.isEmpty() && nextGreaterStoreStack.peek() <= nums[i]) {
                nextGreaterStoreStack.pop();
            }
            ans[i] = (nextGreaterStoreStack.isEmpty() ? -1 : nextGreaterStoreStack.peek());
            nextGreaterStoreStack.push(nums[i]);

        }
        return ans;
    }
}