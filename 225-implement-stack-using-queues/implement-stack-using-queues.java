class MyStack {

    Queue<Integer> myqueue;
    public MyStack() {
        myqueue = new LinkedList<>();
    }
    
    public void push(int x) {
        myqueue.add(x);
        for(int i = 1; i < myqueue.size(); i++) {
            myqueue.add(myqueue.poll());
        }
    }
    
    public int pop() {
        return myqueue.poll();
    }
    
    public int top() {
        return myqueue.peek();
    }
    
    public boolean empty() {
        return myqueue.size() == 0; 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */