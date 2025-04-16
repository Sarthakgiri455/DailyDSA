class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> xors = new HashSet<>();
        for(int i: nums) {
            xors.add(i);
        }
        HashSet<Integer>uniquePairXors = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                uniquePairXors.add(nums[i] ^ nums[j] );
            }
        }
        for(int i: uniquePairXors) {
            for(int j=0;j<nums.length;j++){
                xors.add(i ^ nums[j]);
            }
        }
        
        return xors.size();
    }
}