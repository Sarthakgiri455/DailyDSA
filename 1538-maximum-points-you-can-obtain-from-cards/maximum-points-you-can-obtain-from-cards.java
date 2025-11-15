class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int leftPointer = k-1;
        int max = sum;
        int rightPointer = cardPoints.length - 1;
        for(int i = 0; i<k; i++) {
            int leftValue = cardPoints[leftPointer];
            int rightValue = cardPoints[rightPointer];
            sum = sum - leftValue + rightValue;
            max = Math.max(max, sum);
            rightPointer-=1;
            leftPointer-=1;
        }
        return max;
        
    }
}