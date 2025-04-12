class Solution {
            HashMap<List<Integer>, Integer> dp = new HashMap<>();

    public int maxProduct(int[] nums, int k, int limit) {
        
        int sum = 0;
        for(int i:nums) sum += i;
        sum = Math.min(900, sum);
        if(k<-sum || k>sum) return -1;

        return recursion(nums, k, limit, 1, 0, 0, 0, 1) ;

    }

    public int recursion(int[]nums, int k, int limit, int sign, int index, int sum,  int length, int product)
    {
        if(index == nums.length) {
            if(sum == k && length>0 && product<= limit){
                return product;
            }
            return -1;
        }


        int prod = product;
        if(product>limit) {
            prod = limit + 1;
        }
       
        List<Integer> temp = new ArrayList<>();
        temp.add(prod);
        temp.add(sum);
        temp.add(index);
        temp.add(sign);
        if(dp.containsKey(temp)){
            return dp.get(temp);
        }
        
       int prod1 =  recursion(nums, k, limit, -1*sign, index+1, sum+ (sign*nums[index]),length+1, prod* nums[index]);
        int prod2 = recursion(nums, k, limit, sign, index+1,sum, length, prod);


        // System.out.println("Prod 1 is " + prod1 + " and Prod 2 is " + prod2);

        // System.out.println("Product give is " + prod);
        dp.put(temp, Math.max(prod1, prod2));
        return Math.max(prod1, prod2);
    }
}