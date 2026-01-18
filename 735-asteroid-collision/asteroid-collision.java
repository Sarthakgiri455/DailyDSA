class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer>asteroidsStack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] >= 0){
                asteroidsStack.push(asteroids[i]);
                continue;
            }
            while(!asteroidsStack.isEmpty() && asteroidsStack.peek() >=0 && (Math.abs(asteroids[i]) > asteroidsStack.peek())) {
                asteroidsStack.pop();
            }
            if(!asteroidsStack.isEmpty() && (asteroidsStack.peek() == Math.abs(asteroids[i]))) {
                asteroidsStack.pop();
            }
            else {
                if(asteroidsStack.isEmpty() || asteroidsStack.peek() < 0) {
                    asteroidsStack.push(asteroids[i]);
                }
            }

            
        }
        int[]ansArray = new int[asteroidsStack.size()];
        for(int i = 0; i < ansArray.length; i++) {
            ansArray[ansArray.length - i - 1] = asteroidsStack.pop();
        }
        return ansArray;
    }
}