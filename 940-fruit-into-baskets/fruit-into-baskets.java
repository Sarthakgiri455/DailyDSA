class Solution {
    public int totalFruit(int[] fruits) {
        int firstElement = -1;
        int secondElement = -1;
        int currentCount = 0;
        int lastStreak = 0;
        int max = 0;

        for(int fruit : fruits) {
            if((firstElement == fruit) || (secondElement ==fruit)){
                currentCount+=1;
            }
            else{
                currentCount = lastStreak + 1;
            }
            if(fruit == secondElement) {
                lastStreak = lastStreak+1;
            }
            else {
                lastStreak = 1;
                firstElement = secondElement;
                secondElement = fruit;
            }
            max = Math.max(max, currentCount);
        }
        return max;
    }
}