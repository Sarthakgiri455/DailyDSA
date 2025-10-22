class Solution {
    public int longestOnes(int[] nums, int k) {
        int remaining = k;
        int max = 0;
        int left =0;
        TreeSet<Integer>zeroIndices = new TreeSet<>();

        for(int right = 0; right<nums.length;right++) {
            
            if(nums[right] == 0){
                remaining-=1;
                zeroIndices.add(right);
            }
            if(remaining<0){
                int val = zeroIndices.removeFirst();
                left = val+1;
                remaining+=1;
            }
            
            
            max = Math.max(max, right-left+1);
            System.out.println("Left and right are " + left + " " + right);

        }
        return max;
    }
}