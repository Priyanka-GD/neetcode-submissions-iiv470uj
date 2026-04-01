class TimeMap {
    Map<String, List<Integer>> mapKeyTimestamp;
    Map<Integer, String> mapTimestampVal;

    public TimeMap() {
        mapKeyTimestamp = new HashMap<>();
        mapTimestampVal = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapKeyTimestamp.putIfAbsent(key, new ArrayList<>());
        mapKeyTimestamp.get(key).add(timestamp);
        mapTimestampVal.put(timestamp, value); 
    }
    
    public String get(String key, int timestamp) {
        List<Integer> timestamps = mapKeyTimestamp.getOrDefault(key, new ArrayList<>());
        int left = 0, right = timestamps.size() - 1;
        String result = "";
        while(left <= right){
            int mid = left + (right - left)/2;
            if(timestamps.get(mid) <= timestamp){
                result = mapTimestampVal.get(timestamps.get(mid));
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


