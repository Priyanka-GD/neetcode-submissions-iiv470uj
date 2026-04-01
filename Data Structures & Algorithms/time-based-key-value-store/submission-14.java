class TimeMap {
    Map<String, List<Value>> mapKeyTimestamp;

    public TimeMap() {
        mapKeyTimestamp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapKeyTimestamp.putIfAbsent(key, new ArrayList<>());
        mapKeyTimestamp.get(key).add(new Value(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Value> timestamps = mapKeyTimestamp.getOrDefault(key, new ArrayList<>());
        int left = 0, right = timestamps.size() - 1;
        String result = "";
        while(left <= right){
            int mid = left + (right - left)/2;
            if(timestamps.get(mid).timestamp <= timestamp){
                result = timestamps.get(mid).data;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
}
// key - vey - timestamp(strictly increasing)
// key, timestamp - parameters - return most recent value
// Map<String, List<Integer>> key to timestamp;
// Map<Integer, String> timestamp to value;
// 1, 2, 3, 4, 5, 6 - timestamps
// get(2)


public class Value {
    int timestamp;
    String data;

    public Value(int timestamp, String data) {
        this.timestamp = timestamp;
        this.data = data;
    }
}


