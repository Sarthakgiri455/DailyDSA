class Solution {
    public int maximalRectangle(char[][] matrix) {
        int columns = matrix[0].length;
        int rows = matrix.length;
        int[][]prefixSumArray = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < columns; i++) {
            int prefixSum = 0;
            for(int j = 0; j < rows; j++) {
                prefixSum = prefixSum + (matrix[j][i] - '0');
                prefixSumArray[j][i] = prefixSum;
                if((matrix[j][i] - '0') == 0) {
                    prefixSumArray[j][i] = 0;
                    prefixSum = 0;
                }
            }
        }
        int maxAns = 0;
        for(int[] row : prefixSumArray) {
            System.out.println(Arrays.toString(row));

            maxAns = Math.max(maxAns, largestAreaofRectangularRow(row));
        }
        return maxAns;
    }

    private int largestAreaofRectangularRow(int[] array) {

        Stack<Integer>pSElementIndexes = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < array.length; i++) {
            while(!pSElementIndexes.isEmpty() && array[pSElementIndexes.peek()] > array[i]) {
                int pSElement = -1;
                int poppedElement = pSElementIndexes.pop();
                if(!pSElementIndexes.isEmpty()) {
                    pSElement = pSElementIndexes.peek();
                }
                maxArea = Math.max(maxArea, array[poppedElement] * (i - pSElement - 1));
            }  
            pSElementIndexes.push(i);
        }
        while(!pSElementIndexes.isEmpty()) {
            int pSElement = -1;
            int poppedElement = pSElementIndexes.pop();
            if(!pSElementIndexes.isEmpty()) {
                pSElement = pSElementIndexes.peek();
            }
            maxArea = Math.max(maxArea, array[poppedElement] * (array.length - pSElement - 1));
        }
        return maxArea;
    }

}