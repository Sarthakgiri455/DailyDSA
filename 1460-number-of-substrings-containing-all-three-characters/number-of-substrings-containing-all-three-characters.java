class Solution {
    public int numberOfSubstrings(String s) {
        int[] array = new int[3];
        int leftPointer = 0, n = s.length(), count = 0;
        for(int right = 0; right < s.length(); right++) {
            array[s.charAt(right)-'a']+=1;
            while(array[0] > 0 && array[1] > 0 && array[2] > 0) {
                array[s.charAt(leftPointer)-'a'] -= 1;
                count = count + (n - right);
                leftPointer += 1;
            }
        }
        return count;
    }
}