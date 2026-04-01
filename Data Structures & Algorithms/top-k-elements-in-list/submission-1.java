class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                Pair pair = new Pair(num);
                pair.updateFreq();
                map.put(num, pair);
            } else {
                Pair existingPair = map.get(num);
                existingPair.updateFreq();
                map.put(num, existingPair);
            }
        }
        List<Pair> pairList = new ArrayList<>(map.values());
        Collections.sort(pairList);
        int answer[] = new int[k];
        int idx = 0;
        while(k-- > 0){
            answer[idx] = pairList.get(idx).num;
            idx++;
        }
        return answer;
    }
}
class Pair implements Comparable<Pair>{
    int num;
    int freq;

    public Pair(int num){
        this.num = num;
    }
    public void updateFreq(){
        this.freq++;
    }
    @Override
    public int compareTo(Pair other){
        return other.freq - this.freq;
    }
}
