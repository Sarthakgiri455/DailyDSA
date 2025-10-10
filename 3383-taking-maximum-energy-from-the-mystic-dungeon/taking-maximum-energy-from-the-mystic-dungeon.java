class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[]kDistanceSubsequenceSum = new int[energy.length];
        for(int i = energy.length-1;i>=0;i--) {
            if((i+k)>=energy.length){
                kDistanceSubsequenceSum[i] = energy[i];
            }
            else{
                kDistanceSubsequenceSum[i] = energy[i] + kDistanceSubsequenceSum[i+k];
            }
        }
        return Arrays.stream(kDistanceSubsequenceSum).max().getAsInt();
    }

}