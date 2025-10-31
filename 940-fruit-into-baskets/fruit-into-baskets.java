class Solution {
    public int totalFruit(int[] fruits) {
      int firstElement = -1;
      int secondElement = -1;
      int max = 0;
      int leftPointer = 0;
      for(int i =0; i<fruits.length; i++) {
        if(firstElement == -1){
            firstElement = fruits[i];
        }
        else if(secondElement == -1){
            if(fruits[i] != firstElement) {
                secondElement = fruits[i];
            }
        }
        else{
            if((fruits[i] == firstElement)|| (fruits[i] == secondElement)) {
                // do nothing
            }
            else{
                leftPointer = i-1;
                while(leftPointer>=0 && fruits[leftPointer]==fruits[i-1]) {
                    leftPointer-=1;
                    System.out.println("Decrementing leftPointer "+ leftPointer);
                }
                leftPointer+=1;
                firstElement = fruits[i-1];
                secondElement = fruits[i];
            }
        }
        max = Math.max(max, i-leftPointer+1);

      }
      return max;
    }
}