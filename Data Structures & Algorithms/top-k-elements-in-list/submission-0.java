class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, NumFreq> map = new HashMap<>();
        for (int num : nums) {
            NumFreq numFreq;
            if (map.containsKey(num)) {
                numFreq = map.get(num);
                numFreq.updateFreq();
            } else {
                numFreq = new NumFreq(num);
            }
            map.put(num, numFreq);
        }
        List<NumFreq> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int result[] = new int[k];
        for (int idx = 0; idx < k; idx++) {
            result[idx] = list.get(idx).num;
        }
        return result;
    }
}

class NumFreq implements Comparable<NumFreq> {
    int num;
    int freq;

    public NumFreq(int num) {
        this.num = num;
        this.freq = 1;
    }

    public void updateFreq() {
        this.freq++;
    }

    @Override
    public int compareTo(NumFreq other) {
        return other.freq - this.freq;
    }
}
