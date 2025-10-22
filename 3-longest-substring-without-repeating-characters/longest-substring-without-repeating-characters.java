class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer>count = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right<=s.length()){
            if(right==s.length()){
                max = Math.max(max, right-left);
                break;
            }
            if(count.containsKey(s.charAt(right))){
                int index = count.get(s.charAt(right));
                for(int i = left;i<=index;i++){
                    count.remove(s.charAt(i));
                }
                
                left=index+1;
                
                System.out.println("left is " +left);
                System.out.println("right is " +left);
            }
            else{
                count.put(s.charAt(right),right);
                max = Math.max(max, right-left+1);

                right+=1;
                System.out.println("left is " +left);
                System.out.println("right is " +left);
            }
        }
        return max;
    }
}