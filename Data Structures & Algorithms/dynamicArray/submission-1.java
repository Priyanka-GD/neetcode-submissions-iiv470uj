class DynamicArray {
    private int arr[];
    private int cap;
    private int length; 

    public DynamicArray(int capacity) {
        this.cap = capacity;
        this.length = 0;
        this.arr = new int[cap];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == cap) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        length--;
        return arr[length];
    }

    public void resize() {
        cap = cap * 2;
        int newArr[] = new int[cap];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return cap;
    }
}