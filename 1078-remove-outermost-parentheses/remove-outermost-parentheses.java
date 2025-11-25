class Solution {
    public String removeOuterParentheses(String s) {
        int starting = 0;
        int ending = 0;
        String ans = "";
        int count = 0;
        for(int i = 0; i< s.length();i++) {
            if(s.charAt(i) == '(') {
                count = count + 1;
                if(count!=1){
                    ans+= String.valueOf(s.charAt(i));
                }
            }
            else{
                count = count - 1;
                if(count!=0){
                                        ans+= String.valueOf(s.charAt(i));

                }
            }
 
        }
        return ans;
    }
}