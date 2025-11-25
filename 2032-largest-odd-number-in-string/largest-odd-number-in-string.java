class Solution {
    public String largestOddNumber(String num) {
        int endIndex = 0;
        for(int i = num.length() -1 ; i >= 0; i--) {
            int value = num.charAt(i) - '0';
            if(value % 2 == 1) {
                endIndex = i+1;
                break;
            }
        }
        return num.substring(0, endIndex);
    }
}