class LRUCache {
    private Map<Integer, Data> cache;
    Data tail;
    Data head;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        tail = new Data(-1, -1);
        head = new Data(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Data existingData = cache.get(key);
            removeData(existingData);
            insertData(existingData);
            return existingData.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Data keyData = cache.get(key);
            removeData(keyData);
            //cache.remove(key);
        }
        Data newData = new Data(key, value);
        insertData(newData);
        cache.put(key, newData);
        if(cache.size() > capacity){
            Data evictData = tail.prev;
            removeData(evictData);
            cache.remove(evictData.key);
        }
    }
    private void removeData(Data toRemove){
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }
    private void insertData(Data data){
        Data next = head.next;
        head.next = data;
        data.next = next;
        data.prev = head;
        next.prev = data;
    }
}

class Data {
    Data prev;
    Data next;
    int value;
    int key;
    public Data(int key, int value){
        this.key = key;
        this.value = value;
    }
    }


