class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int[]ans = new int[spells.length];
        Arrays.sort(potions);
        int index = 0;
        for(int spell: spells) {
            int minimumValue = (int)Math.ceil(success/(double)spell);
            System.out.println(minimumValue);
            int indexWithMinimumValue = binarySearch(potions, minimumValue);
            ans[index] = (indexWithMinimumValue == -1) ? 0 : (potions.length - indexWithMinimumValue);
            index+=1;
        }
        return ans;
        
    }

    int binarySearch(int[] potions, int minimumValue) {
        int left = 0;
        int right = potions.length-1;
        int ans = -1;
        while(left<=right) {
            int mid = left+(right-left)/2;
            if(potions[mid] >=minimumValue) {
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
}