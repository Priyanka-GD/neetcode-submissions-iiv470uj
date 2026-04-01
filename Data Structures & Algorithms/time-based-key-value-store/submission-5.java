class TimeMap {
    Map<String, Map<Integer, String>> map;
    Map<String, List<Integer>> timestampsMap;

    public TimeMap() {
        map = new HashMap<>();
        timestampsMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>());
            timestampsMap.put(key, new ArrayList<>());
        }
        map.get(key).put(timestamp, value);
        timestampsMap.get(key).add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Integer> listOfTimestamps = timestampsMap.get(key);
        int left = 0, right = listOfTimestamps.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (listOfTimestamps.get(mid) <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0)
            return ""; // No valid timestamp found
        int validTimestamp = listOfTimestamps.get(right);
        return map.get(key).get(validTimestamp);
    }
}

