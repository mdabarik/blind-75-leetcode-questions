class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    } // TC: O(log n), SC: O(log n)
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) { // even number of integers
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.peek();
    } // TC: O(1), SC: O(1)
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
