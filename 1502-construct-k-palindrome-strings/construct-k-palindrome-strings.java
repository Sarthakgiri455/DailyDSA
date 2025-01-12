class Solution {
    public boolean canConstruct(String s, int k) {
       if(k>s.length()) {
        return false;
       }
       if(s.length()==k){
            return true;
       }
      int[]alpha = new int[26];
      for(int i = 0; i<s.length();i++) {
        alpha[s.charAt(i)-'a']+=1;
      }
      int odd = 0;
      for(int i: alpha) {
        if(i%2 ==1){
            odd+=1;
        }
      }
      return odd<=k;
    }

}