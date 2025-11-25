class Solution {
    public String removeOuterParentheses(String s) {
        int starting = 0;
        int ending = 0;
        String ans = "";
        Stack<Character>storage = new Stack<>();
        for(int i = 0; i< s.length();i++) {
            char x = s.charAt(i);
            if(x == '(') {
                if(storage.isEmpty()) {
                    starting = i;
                }
                storage.push('(');
            } 
            else {
                storage.pop();
                if(storage.isEmpty()) {
                    ending = i;
                    ans = ans + s.substring(starting+1, ending);
                }
            }
            
        }
        return ans;
    }
}