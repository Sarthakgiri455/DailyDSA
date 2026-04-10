class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i: nums) {
            minheap.offer(i);
        }
        for(int i = 0; i < nums.length - k; i++){
            minheap.poll();
        }
        return minheap.poll();
    }
}