class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> mapOfValues = new HashMap<>();
        int[] result = new int[queries.length];

        for (int interval[] : intervals) {
            int start = interval[0];
            int end = interval[1];
            int range = end - start + 1;
            for (int idx = start; idx <= end; idx++) {
                if (mapOfValues.containsKey(idx)) {
                    int minVal = Math.min(range, mapOfValues.get(idx));
                    mapOfValues.put(idx, minVal);
                } else {
                    mapOfValues.put(idx, range);
                }
            }
        }
        int i = 0;
        for (int query : queries) {
            if (!mapOfValues.containsKey(query)) {
                result[i] = -1;
            } else {
                result[i] = mapOfValues.get(query);
            }
            i++;
        }
        return result;
    }
}