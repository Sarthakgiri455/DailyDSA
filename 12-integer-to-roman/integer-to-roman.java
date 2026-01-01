class Solution {
    public String intToRoman(int num) {
        int[]justSmaller = new int[]{1, 2, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        Map<Integer, String> intToRomanMap = new HashMap<>();
        intToRomanMap.put(1, "I");
        intToRomanMap.put(2, "II");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(1000, "M");
        
        String ans = "";
        while(num > 0) {
            if(intToRomanMap.containsKey(num)) {
                ans = ans + intToRomanMap.get(num);
                return ans;
            }
            else{
                int res = justSmaller(num, justSmaller);
                System.out.println("Result is " + res);
                ans = ans + intToRomanMap.get(res);
                System.out.println("Remaining  is " + (num - res));
                num = num - res;
            }
        }
        return ans;
    }

    private int justSmaller(int number, int[] binarySearchArray) {
        int start = 0;
        int end = binarySearchArray.length-1;
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(binarySearchArray[mid] > number) {
                end = mid-1;
            }
            else{
                ans = binarySearchArray[mid];
                start = mid+1;
            }
        }
        return ans;
    }
}