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
        int maxTime = Integer.MIN_VALUE;
        for(int time : timestamps){
            if(time <= timestamp){
                maxTime = Math.max(time, maxTime);
            }
            else{
                break;
            }
        }
        if(maxTime == Integer.MIN_VALUE)
            return "";
        return mapTimestampVal.get(maxTime);
    }
}
// key - vey - timestamp(strictly increasing)
// key, timestamp - parameters - return most recent value
// Map<String, List<Integer>> key to timestamp;
// Map<Integer, String> timestamp to value;
// 1, 2, 3, 4, 5, 6 - timestamps
// get(2)


