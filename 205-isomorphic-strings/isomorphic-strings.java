class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[]charactersMapping = new int[256];
        Arrays.fill(charactersMapping, -1);
        Set<Character>mapped = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(charactersMapping[(int)s.charAt(i)]!= -1) {
                if(charactersMapping[(int)s.charAt(i)] != (int)(t.charAt(i))) 
                {
                    return false;
                }
            }
            else {
                if(mapped.contains(t.charAt(i)))
                {
                    return false;
                }
                charactersMapping[(int)s.charAt(i)] = (int)t.charAt(i);
                mapped.add(t.charAt(i));
            }
        }
        return true;
        
    }
}