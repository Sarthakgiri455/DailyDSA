class MinStack {

    Stack<Long>stackWithMin; 
    long minSoFar = 0;
    public MinStack() {
       stackWithMin = new Stack<>();
    }
    
    public void push(int val) {
        if(stackWithMin.isEmpty()) {
            stackWithMin.push((long)val);
            minSoFar = val;
            return;
        }
        if(val < minSoFar) {
            stackWithMin.push((long) (val - minSoFar + val));
            minSoFar = val;
        }
        else{
            stackWithMin.push((long)val);
        }
    }
    
    public void pop() {
        long poppedVal = stackWithMin.pop();
        if(poppedVal < minSoFar) {
            minSoFar =  minSoFar - poppedVal + minSoFar; 
        }
    }
    
    public int top() {
        long peekedVal = stackWithMin.peek();
        System.out.println("Peeked value is "+ peekedVal);
        System.out.println("Stack length is  "+ stackWithMin.size());
        if(peekedVal > minSoFar) {
            return (int)peekedVal;
        }
        return (int)minSoFar;
    }
    
    public int getMin() {
        return (int)minSoFar;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */