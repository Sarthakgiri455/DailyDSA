class StockSpanner {
    Stack<int[]> stockSpannerStack;
    int index; 
    public StockSpanner() {
        stockSpannerStack = new Stack<int[]>();
        index = 0;
    }
    
    public int next(int price) {
        
        while(!stockSpannerStack.isEmpty() && stockSpannerStack.peek()[1] <= price ) {
            stockSpannerStack.pop();
        }
        int lastSmallerDay = -1;
        if(!stockSpannerStack.isEmpty()) {
            lastSmallerDay = stockSpannerStack.peek()[0];
        }
        int ans = index - lastSmallerDay;
        stockSpannerStack.push(new int[]{index , price});
        index+=1;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */