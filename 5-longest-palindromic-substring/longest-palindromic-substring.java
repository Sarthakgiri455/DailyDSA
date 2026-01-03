class Solution {
    int maxSoFar = 0;
    public String longestPalindrome(String s) {
         
         String ans = String.valueOf(s.charAt(0)); 
        for(int i = 0; i < s.length() - 1; i++) {
            String temp1 = (s.charAt(i) == s.charAt(i+1)) ? longestPalindromefromCenter(i, i+1, s) : String.valueOf(s.charAt(i));
            System.out.println("Temp1 is " + temp1);
            String temp2 = (i == 0) ? String.valueOf(s.charAt(0)) : longestPalindromefromCenter(i, i, s);
            System.out.println("Temp2 is " + temp2);
            System.out.println("MAx so far "+ maxSoFar);
            if(temp1.length() > maxSoFar) {
                ans = temp1; 
                maxSoFar = temp1.length();
            }
            if(temp2.length() > maxSoFar) {
                ans = temp2;
                maxSoFar = temp2.length();
            }
        }
        return ans;
    }
    private String longestPalindromefromCenter(int start, int end, String s) {
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) == s.charAt(end)) {
                start-=1;
                end+=1;
            }
            else{
                break;
            }
        }
        return s.substring(start+1, end);
    }
}