class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer>rainLakeIndex = new HashMap<>();
        TreeSet<Integer>zerosIndex = new TreeSet<>();
        int[]arr = new int[rains.length];
        int maxIndex = Integer.MIN_VALUE;
        for(int i = 0; i < rains.length; i++) {
            if(rains[i] == 0) {
                zerosIndex.add(i);
                continue;
            }
            if(rainLakeIndex.containsKey(rains[i])) {
                
                int lastIndexOfRainI = rainLakeIndex.get(rains[i]);
                Iterator<Integer> itr = zerosIndex.iterator();
                int removeIndex = -1;
                while(itr.hasNext()) {
                    Integer val = itr.next();
                    if(val>lastIndexOfRainI){
                        arr[val] = rains[i];
                        removeIndex = val;
                        break;
                    }
                }
                zerosIndex.remove(removeIndex);                
                if(removeIndex == -1){
                    return new int[]{};
                }
                rainLakeIndex.remove(rains[i]);
                rainLakeIndex.put(rains[i], i);
            }
            else {
                maxIndex = Math.max(maxIndex, rains[i]);
                rainLakeIndex.put(rains[i], i);
            }
            arr[i] = -1;
        }
        System.out.println("Max index is" +maxIndex);
        for(int i = 0;i<arr.length;i++) {
            if(arr[i]==0){
                arr[i] = maxIndex+1;
            }
        }
        return arr;
    }
}