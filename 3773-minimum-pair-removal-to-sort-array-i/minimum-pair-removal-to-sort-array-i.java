class Solution {
    public int minimumPairRemoval(int[] nums) {
List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }        

        int step =0;
        while(true){
        int min = Integer.MAX_VALUE;
        int replaceIndex = 0;
        boolean nonDecreasing = true;
        for(int i = 0;i<list.size()-1;i++)
        {
        
            if(list.get(i)+list.get(i+1) < min){
                replaceIndex = i;
                min = list.get(i) + list.get(i+1);
            }
            
            if(list.get(i)> list.get(i+1)){
                nonDecreasing = false;
            }
        }
        if(nonDecreasing) {
            break;
        }
        step+=1;
        list.set(replaceIndex, min);
        list.remove(replaceIndex+1);
        }
        
        return step;
    }
}