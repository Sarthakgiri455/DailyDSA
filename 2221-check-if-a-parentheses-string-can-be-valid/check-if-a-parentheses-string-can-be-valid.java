class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer>entries = new Stack<>();
        Stack<Integer>openCharacters = new Stack<>();
        int index =0;
        if(s.length()%2 ==1){return false;}
        while(index<s.length()){
            if(locked.charAt(index)=='0'){
                openCharacters.push(index);
            }
            else if (s.charAt(index) == '('){
                   entries.push(index); 
                
            }
            else if (s.charAt(index) == ')'){
                if(!entries.isEmpty()){
                    entries.pop();
                }
                else if(!openCharacters.isEmpty()) {
                    openCharacters.pop();
                }
                else{
                    return false;
                }
            }
            index+=1;
        }
        while(!openCharacters.isEmpty() && !entries.isEmpty() && openCharacters.peek() > entries.peek()){
            openCharacters.pop();
            entries.pop();
        }
        return entries.isEmpty();

    }
}