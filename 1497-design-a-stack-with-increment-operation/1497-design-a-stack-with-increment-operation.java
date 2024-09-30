class CustomStack {

    int[] arr;
    int size;
    int ind;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        size=maxSize;
        ind=0;
    }

    public void push(int x) {
        if (ind<size) {
            arr[ind] = x;
            ind++;
        }
    }

    public int pop() {
        if (ind == 0) {
            return -1;
        }
       ind--;
        return arr[ind];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, ind); i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */