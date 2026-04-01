class DynamicArray {
    int[] arr;
    int arrLength;
    int capacity;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.arrLength = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(arrLength == capacity){
            resize();
        }
        arr[arrLength] = n;
        arrLength++;
    }

    public int popback() {
        if(arrLength > 0){
            arrLength--;
        }
        return arr[arrLength];
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for(int i = 0; i < arrLength; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return arrLength;
    }

    public int getCapacity() {
        return capacity;
    }
}
