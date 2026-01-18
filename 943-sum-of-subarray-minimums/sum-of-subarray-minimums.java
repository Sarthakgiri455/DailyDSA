class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[]nSEArray = new int[arr.length];
        int[]pSEArray = new int[arr.length];
        int mod = (int)1e9+7;
        Stack<Integer>nSE = new Stack<Integer>();
        Stack<Integer>pSE = new Stack<Integer>();
        nSE.push(arr.length);
        pSE.push(-1);
        for(int i = nSEArray.length-1; i >=0; i--) {
            while(!nSE.isEmpty() &&  nSE.peek()!=arr.length && arr[nSE.peek()] > arr[i]) {
                nSE.pop();
            }
            nSEArray[i] = nSE.peek() - i;
            nSE.push(i);
        }

        for(int i = 0; i < arr.length; i++) {
            while(!pSE.isEmpty() && pSE.peek()!=-1 && arr[pSE.peek()] >= arr[i]) {
                pSE.pop();
            }
            pSEArray[i] = i - pSE.peek();
            pSE.push(i);
        }

        long ans = 0;
        for(int i = 0; i < nSEArray.length; i++) {
            ans = (ans + ((long)nSEArray[i] * (long)pSEArray[i] * (long) arr[i]) % mod) % mod;
        }
        return (int)ans;
    }
}