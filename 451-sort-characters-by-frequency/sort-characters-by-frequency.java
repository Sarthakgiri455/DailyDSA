class Solution {
    public String frequencySort(String s) {
        int[][]frequency = new int[256][2];
        for(int i = 0; i<256;i++) {
            frequency[i][0] = i;
        }
        for(int i =0; i<s.length();i++){
            int val = (int)s.charAt(i);
            frequency[val][1]+=1;
        }
        Arrays.sort(frequency, (a,b)->b[1] - a[1]);
        System.out.println(Arrays.toString(frequency));
        String ans = "";
        for(int i = 0; i<frequency.length;i++) {
            for(int j = 0; j < frequency[i][1]; j++) {
                ans = ans + (char)frequency[i][0];
            }
        }
        return ans;
    }
}