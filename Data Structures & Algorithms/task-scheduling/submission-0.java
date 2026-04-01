class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue());
        
        for(int idx = 0; idx < 26; idx++){
            if(freq[idx] > 0)
                maxHeap.add(new Pair<>((char)(idx + 'A'), freq[idx]));
        }
        int time = 0;
        while(!maxHeap.isEmpty()){
            List<Pair<Character, Integer>> list = new ArrayList<>();
            int cycle = n + 1;
            int taskCount = 0;

            while(!maxHeap.isEmpty() && cycle-- > 0){
                Pair<Character, Integer> taskEle = maxHeap.poll();
                int occurrence = taskEle.getValue();
                occurrence--;
                if(occurrence > 0){
                    list.add(new Pair<>(taskEle.getKey(), occurrence));
                }
                taskCount++;
            }
            maxHeap.addAll(list);
            time += maxHeap.isEmpty()? taskCount : (n + 1);
        }
        return time;
    }
}
