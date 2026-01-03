class Solution {
    public String reverseWords(String s) {
        List<String>a1 = new ArrayList<>();
        String newString = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== ' ') {
                if(i>0 && s.charAt(i-1)!= ' '){
                    a1.add(newString);
                    newString = "";
                }
            }
            else{
                newString+=String.valueOf(s.charAt(i));
            }
            
        }
        if(newString.length()>0){
            a1.add(newString);
        }
        String ans = "";
        for(int i = 0; i<a1.size();i++){
            String temp = a1.get(a1.size() - 1 - i);
            ans = ans + temp;
            if(i!=a1.size()-1){
                ans = ans + " ";
            }
        }

        return ans;
    }

}