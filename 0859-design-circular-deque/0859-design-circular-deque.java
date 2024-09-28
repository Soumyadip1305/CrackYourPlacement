class MyCircularDeque {
Deque<Integer> queue;
    int maxSize;

    public MyCircularDeque(int k) {
        queue = new LinkedList<>();
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (queue.size() < maxSize) {
            queue.addFirst(value);
            return true;
        } else return false;
    }

    public boolean insertLast(int value) {
        if (queue.size() < maxSize) {
            queue.offerLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!queue.isEmpty()){
            queue.pollFirst();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!queue.isEmpty()){
            queue.pollLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        return queue.isEmpty() ? -1 : queue.peekFirst();
    }

    public int getRear() {
        return queue.isEmpty() ? -1 : queue.peekLast();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */