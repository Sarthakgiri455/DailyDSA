class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>contents = new HashSet<>();
        int left = 0;
        int max =0;
        for(int right = 0; right<s.length();right++) {
            while(left<right && contents.contains(s.charAt(right))){
                contents.remove(s.charAt(left));
                left = left +1;
            }
            contents.add(s.charAt(right));
            max = Math.max(max, right-left+1);
            System.out.println("The left right and max are " + left +"  "+right+" "+max);
        }
        return max;
    }
}