class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer>sContent = new HashMap<>();
        Map<Character, Integer>tContent = new HashMap<>();
        HashSet<Character>tCountMatching = new HashSet<>();
        int leftIndex = -1; 
        int rightIndex = -1;
        for(int i = 0; i < t.length(); i++) {
            tContent.put(t.charAt(i), tContent.getOrDefault(t.charAt(i), 0)+1);
        }
        int leftPointer = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0 ; right< s.length(); right++) {
            sContent.put(s.charAt(right), sContent.getOrDefault(s.charAt(right), 0)+1);
            int tCount = tContent.getOrDefault(s.charAt(right), 0);
            int sCount = sContent.getOrDefault(s.charAt(right), 0);
            if(sCount >= tCount && tContent.containsKey(s.charAt(right))) {
                tCountMatching.add(s.charAt(right));
            }
            // a a b b c c e   a b c e 
            while(tCountMatching.size() == tContent.size()) {
                if(right - leftPointer + 1 < minLength) {
                    leftIndex = leftPointer;
                    rightIndex = right;
                    minLength = right - leftPointer + 1;
                }
                sContent.put(s.charAt(leftPointer), sContent.get(s.charAt(leftPointer)) - 1);
                int tCountTemp = tContent.getOrDefault(s.charAt(leftPointer), 0);
                int sCountTemp = sContent.getOrDefault(s.charAt(leftPointer), 0);
                if(tCountTemp > sCountTemp) {
                    tCountMatching.remove(s.charAt(leftPointer));
                }
                if(sContent.get(s.charAt(leftPointer)) == 0) {
                    sContent.remove(s.charAt(leftPointer));
                }
                leftPointer += 1;
            }
        }
        return (leftIndex != -1 && rightIndex != -1) ? s.substring(leftIndex, rightIndex+1) : "";
    }
}