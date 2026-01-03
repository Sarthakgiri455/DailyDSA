class MyQueue {

    Stack<Integer>myStack1;
    Stack<Integer>myStack2;
    public MyQueue() {
        myStack1 = new Stack<>();
        myStack2 = new Stack<>();
    }
    
    public void push(int x) {
        myStack1.push(x);
    }
    
    public int pop() {
        if(!myStack2.isEmpty()) {
            return myStack2.pop();
        }
        while(!myStack1.isEmpty()) {
            myStack2.push(myStack1.pop());
        }
        return myStack2.pop();
    }
    
    public int peek() {
                if(!myStack2.isEmpty()) {
            return myStack2.peek();
        }
                while(!myStack1.isEmpty()) {
            myStack2.push(myStack1.pop());
        }
        return myStack2.peek();
    }
    
    public boolean empty() {
        return myStack1.isEmpty() && myStack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */