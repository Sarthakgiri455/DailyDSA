class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> sumsMap = new HashMap<>();

        int prefixSum = 0;
        long ans = 0;
        sumsMap.put(0, 1); 

        for (int i = 0; i < nums.size(); i++) {
            prefixSum += (nums.get(i) % modulo == k ? 1 : 0);
            ans += sumsMap.getOrDefault((prefixSum - k + modulo) % modulo, 0);
            sumsMap.put(prefixSum % modulo, sumsMap.getOrDefault(prefixSum % modulo, 0) + 1);
        }
        return ans;
    }
}
