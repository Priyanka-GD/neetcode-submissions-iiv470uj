class TimeMap {
    // We'll store a list of these pairs for every key
    class Data {
        int timestamp;
        String value;

        Data(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        // Since timestamps come in increasing order, the list stays sorted
        map.get(key).add(new Data(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Data> list = map.get(key);
        int low = 0, high = list.size() - 1;
        String res = "";

        // Classic Binary Search for the "Floor" value
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                // This could be the answer, but let's check for a 
                // larger timestamp closer to the target
                res = list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}

/**
By leveraging the fact that timestamps are provided in strictly increasing order, 
I chose to use an ArrayList of Pairs for each key. 
This allows the set operation to be O(1) while keeping the data sorted for the get operation.
This results in O(log N) retrieval time without the overhead of sorting or the higher memory overhead of a TreeMap 
*/