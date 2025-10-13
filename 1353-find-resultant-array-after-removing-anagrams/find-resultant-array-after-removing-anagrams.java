class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String>ans = new ArrayList<>();
        int[]prevArray = new int[26];
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            int[]tempArray = new int[26];
            for(int j = 0;j<word.length();j++) {
                int index = word.charAt(j)-'a';
                tempArray[index]+=1;
            }
            if(i==0){
                prevArray = tempArray.clone();
                ans.add(word);
            }
            else{
                if(!Arrays.equals(tempArray, prevArray)){
                    prevArray = tempArray.clone();
                    ans.add(word);
                }
            }
            
        }
        return ans;
        
    }
}