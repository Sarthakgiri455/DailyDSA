class Solution {
    public int largestRectangleArea(int[] heights) {
       Stack<Integer>pSE = new Stack<>();
       int maxArea = 0;
       for(int i = 0; i < heights.length; i++) {
            while(!pSE.isEmpty() && heights[pSE.peek()] > heights[i]) {
                int element = pSE.pop();
                int nSEIndex = i;
                int pSEIndex = -1;
                if(!pSE.isEmpty()) {
                    pSEIndex = pSE.peek();
                }
                maxArea = Math.max(maxArea, heights[element] * (i - pSEIndex - 1));
            }
            pSE.push(i);
       } 
       int nSE = heights.length;
       while(!pSE.isEmpty()) {
            int poppedElement = pSE.pop();
            int pSEIndex = -1;
            if(!pSE.isEmpty()) {
                pSEIndex = pSE.peek();
            }
            maxArea = Math.max(maxArea, heights[poppedElement] * (nSE - pSEIndex - 1));
       }
       return maxArea;
    }
}