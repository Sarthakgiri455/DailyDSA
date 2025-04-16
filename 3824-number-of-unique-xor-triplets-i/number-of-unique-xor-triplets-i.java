class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return 2;
        }

        if (isPowerOf2(nums.length + 1)) {
            return nums.length + 1;
        }

        int largestBit = findLargestBit(nums.length)+1;
        return (int) Math.pow(2, largestBit) ;
    }

    boolean isPowerOf2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count == 1;
    }

    int findLargestBit(int n) {
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                index = i;
            }
        }
        return index;
    }
}
