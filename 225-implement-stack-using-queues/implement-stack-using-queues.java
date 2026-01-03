class MyStack {

    Queue<Integer> myqueue;
    public MyStack() {
        myqueue = new LinkedList<>();
    }
    
    public void push(int x) {
        myqueue.add(x);

    }
    
    public int pop() {
        for(int i = 1; i < myqueue.size(); i++) {
            myqueue.add(myqueue.poll());
        }
        return myqueue.poll();
    }
    
    public int top() {
        for(int i = 1; i < myqueue.size(); i++) {
            myqueue.add(myqueue.poll());
        }

        int val =  myqueue.peek();
        myqueue.add(myqueue.poll());
        return val;
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