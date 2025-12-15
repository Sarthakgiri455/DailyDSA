class Solution {
    public int maxDepth(String s) { 
        int max = 0;
        int val = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                val = val + 1;
            }
            if(s.charAt(i) == ')') {
                val = val -1;
            }
            max = Math.max(max, val);
        }
        return max;
    }
}