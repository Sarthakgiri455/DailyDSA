class Solution {
    public String smallestPalindrome(String s) {
        int[]arr = new int[26];
        for(int i =0;i<s.length();i++){
            arr[s.charAt(i)-'a']+=1;
        }
        String oddChar = "";
        for(int i = 0;i<26;i++){
            if(arr[i]%2 ==1){
                oddChar = String.valueOf((char)('a'+i));
            }
            arr[i]/=2;
        }
        String palindrome = "";
        for(int i=0;i<26;i++){
            for(int j=0;j<arr[i];j++){
                palindrome+=String.valueOf((char)('a'+i));
            }
        }
        return palindrome+oddChar+new StringBuilder(palindrome).reverse().toString();
    }
}