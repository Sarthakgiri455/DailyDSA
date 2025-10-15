class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int startIndexIncreasingSubarray = 0;
        int endIndexIncreasingSubarray = 1;
        int currentIndex = 0;

        ArrayList<int[]>rangeOfStrictlyIncreasing = new ArrayList<>();
        
        while(endIndexIncreasingSubarray<=nums.size()) {
            if(endIndexIncreasingSubarray == nums.size()) {
                rangeOfStrictlyIncreasing.add(new int[]{startIndexIncreasingSubarray, endIndexIncreasingSubarray-1});
                break;
            }
            if(nums.get(endIndexIncreasingSubarray) > nums.get(endIndexIncreasingSubarray-1)) {
                endIndexIncreasingSubarray+=1;
            }
            else{
                rangeOfStrictlyIncreasing.add(new int[]{startIndexIncreasingSubarray, endIndexIncreasingSubarray-1});
                startIndexIncreasingSubarray = endIndexIncreasingSubarray;
                endIndexIncreasingSubarray+=1;
            }

        }
        int max = 0;
        int prevLastIndex = -1;
        
        for(int[]a: rangeOfStrictlyIncreasing) {
            System.out.println(Arrays.toString(a));
        }
        if(rangeOfStrictlyIncreasing.size()==1){
            return (rangeOfStrictlyIncreasing.get(0)[1]-rangeOfStrictlyIncreasing.get(0)[0]+1)/2;
        }
        for(int i =1;i<rangeOfStrictlyIncreasing.size();i++) {
             int firstLength = rangeOfStrictlyIncreasing.get(i-1)[1]-rangeOfStrictlyIncreasing.get(i-1)[0]+1;
                int secondLength = rangeOfStrictlyIncreasing.get(i)[1]-rangeOfStrictlyIncreasing.get(i)[0]+1;
            if(rangeOfStrictlyIncreasing.get(i-1)[1] == rangeOfStrictlyIncreasing.get(i)[0]-1) {
               
                max = Math.max(max, Math.min(firstLength, secondLength));
            }
            max = Math.max(max, secondLength/2);
            max = Math.max(max, firstLength/2);
            
        }
        return max;
        
    }
}