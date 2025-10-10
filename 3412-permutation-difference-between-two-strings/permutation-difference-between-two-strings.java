class Solution {
    public int findPermutationDifference(String s, String t) {
        int[]characterIndex = new int[26];
        for(int i = 0;i<s.length();i++) {
            int index = s.charAt(i) -'a';
            characterIndex[index] = i;
        }
        int total = 0;
        for(int j=0;j<t.length();j++) {
            int index = t.charAt(j)-'a';
            total+=(Math.abs(characterIndex[index]-j));
        }
        return total;
    }
}