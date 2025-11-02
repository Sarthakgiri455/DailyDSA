class Solution {
    public int characterReplacement(String s, int k) {
        int[]frequencyArray = new int[26];
        int ans = 0;
        int leftPointer = 0;
        for(int right = 0; right<s.length();right++) {
            int index = (s.charAt(right)-'A');
            frequencyArray[index]+=1;
            int maxFrequency = Arrays.stream(frequencyArray).max().getAsInt();
            
            if((right-leftPointer+1-maxFrequency) <= k) {
                ans = Math.max(ans, right-leftPointer+1);
            }
            else{
                int removalIndex = (s.charAt(leftPointer)-'A');
                frequencyArray[removalIndex]-=1;
                leftPointer+=1;
            }
        }
        return ans;
    }
}