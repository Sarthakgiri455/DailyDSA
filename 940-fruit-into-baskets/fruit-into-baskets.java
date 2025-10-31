class Solution {
    public int totalFruit(int[] fruits) {
        int[][]array = new int[2][2];
        for(int[] i: array) {
            Arrays.fill(i, -1);
        }
        int max = 0;
        int leftPointer = 0;
        for(int j=0;j<fruits.length;j++){
            if(array[0][0] == -1) {
                array[0][0] = fruits[j];
                array[0][1] = j;
                max = 1;
            }
            else if(array[1][0] == -1) {
                
                if(fruits[j]!=array[0][0])
                {
                    System.out.println("Reaching here");
                    array[1][0] = fruits[j];
                    array[1][1] = j;
                }
                else{
                    array[0][1] = j;
                }

                
            }
            else{
                boolean found = false;
                for(int i = 0;i<2;i++){

                    if(array[i][0] == fruits[j]) {
                        found = true;
                        array[i][1] = j;
                    }
                }
                if(found == false) {
                    array[0][0] = array[1][0];
                    leftPointer = array[0][1] + 1;
                    array[0][1] = array[1][1];
                    array[1][0] = fruits[j];
                    array[1][1] = j;
                    
                }
                else{
                    Arrays.sort(array, (a,b)->a[1]-b[1]);
                }
            }
            for(int[] i: array){
                System.out.println(Arrays.toString(i));
            }
            max = Math.max(max, j-leftPointer+1);
        }
        return max;
    }
}