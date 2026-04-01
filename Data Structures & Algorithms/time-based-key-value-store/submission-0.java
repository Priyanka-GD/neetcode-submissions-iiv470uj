class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> entryMap = map.getOrDefault(key, new TreeMap<>());
        entryMap.put(timestamp, value);
        map.put(key, entryMap);    
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> entryMap = map.getOrDefault(key, new TreeMap<>());
        Map.Entry<Integer, String> entry = entryMap.floorEntry(timestamp);
        return entry != null ? entry.getValue() : "";
    }
}

/*
So, Map<String, Map<Integer, String>> -- <Key : <Timestamp : Value>>

*/