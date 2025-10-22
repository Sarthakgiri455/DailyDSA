class Solution {
    public int longestOnes(int[] nums, int k) {
        int remaining = k;
        int max = 0;
        int left =0;
        for(int right = 0; right<nums.length;right++) {
            if(nums[right]==0) {
                remaining-=1;
            }
            while(remaining<0) {
                if(nums[left]==0){
                    left+=1;
                    remaining+=1;
                    break;
                }  
                left+=1;          
            }
            
            max = Math.max(max, right-left+1);
            System.out.println("Left and right are " + left + " " + right);

        }
        return max;
    }
}