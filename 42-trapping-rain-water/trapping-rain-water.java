class Solution {
    public int trap(int[] height) {
       int leftPointer = 0; 
       int rightPointer = height.length - 1;
       int lMax= 0; 
       int rMax = 0;
       int ans = 0;
       while(leftPointer < rightPointer) {
        if(height[leftPointer] <= height[rightPointer]) {
            if(height[leftPointer] < lMax) {
                ans = ans + (lMax - height[leftPointer]);
            }
            else {
                lMax = height[leftPointer];
            }
            leftPointer+=1;

        }
        else{

            if(height[rightPointer] < rMax) {
                ans = ans + (rMax - height[rightPointer]);
            }
            else {
                rMax = height[rightPointer];
            }
            rightPointer-=1;

        }
       }
       return ans;
    }
}