class Solution {
    public int longestBalanced(String s) {
            int onesCount = 0;
            int zerosCount = 0;
        for(int i = 0; i < s.length();i++) {

            if(s.charAt(i) == '1') {
                onesCount +=1;
            }
            else {
                zerosCount+=1;
            }
        }
        int sum = 0;
        Map<Integer, List<Integer>>indexMap = new HashMap<>();
        int ans = 0;
        indexMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='0') {
                sum-=1;
            }
            else{
                sum+=1;
            }
            if(indexMap.containsKey(sum)) {

                List<Integer> indexes = indexMap.get(sum);
                for(int q: indexes) {
                    int length = i - q;
                    ans = Math.max(ans, length);
                    break;
                }
            }
            if(indexMap.containsKey(sum-2)) {

                List<Integer> indexes = indexMap.get(sum-2);
                for(int q: indexes) {
                int length = i - q;
                int ones = (length - 2)/ 2 + 2;
                int zeros = length - ones;
                if(zerosCount > zeros) {
                    ans = Math.max(ans, length);
                    break;
                }
                }
            }
            if(indexMap.containsKey(sum+2)){
                List<Integer> indexes = indexMap.get(sum+2);
                for(int q: indexes) {
                    int length = i - q;
                    int zeros = (length - 2)/ 2 + 2;
                    int ones = length - zeros;
                    if(onesCount > ones) {
                        ans = Math.max(ans, length);
                        break;
                    }
                }
            }
            List<Integer>indexes = indexMap.getOrDefault(sum, new ArrayList<Integer>());
            if(indexes.size() < 2){
                indexes.add(i);
            }
            indexMap.put(sum, indexes);
        }

        return ans;
    }
}