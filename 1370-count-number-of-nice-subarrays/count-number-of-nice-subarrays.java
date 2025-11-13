class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
      int left = 0;
      int right = 0;
      int count = 0;
      int ans = 0;
      int checkPoint = 0;
      while(right < nums.length) {
        if(!isOdd(nums[right])){
            right+=1;

        }
        else{
            count+=1;
            if(count == k) {
                checkPoint = right;


                right+=1;
                while(right<nums.length && !isOdd(nums[right])) {
                    right+=1;
                }
                while(count == k) {
                    if(isOdd(nums[left])){
                        count-=1;
                    }

                    ans = ans + (right - checkPoint);
                    left+=1;
                }
            }
            else{
                right+=1;
            }
        }
        
      }
      return ans;
    }

    private boolean isOdd(int number) {
        return number%2 ==1;
    }
}