class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] countOfTasks = new int[26];
        for(char task : tasks){
            countOfTasks[task - 'A']++;
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for (int i = 0; i < 26; i++) {
            int freq = countOfTasks[i];
            if (freq > 0) {
                maxHeap.add(new Pair((char) ('A' + i), freq));
            }
        }
        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Pair> list = new ArrayList<>();
            int count = n + 1;
            int tasksInCycle = 0;

            while (count > 0 && !maxHeap.isEmpty()) {
                Pair currPair = maxHeap.poll();
                tasksInCycle++;
                currPair.freq--;
                
                if (currPair.freq > 0) {
                    list.add(currPair);
                }
                count--;
            }

            if (!list.isEmpty()) {
                maxHeap.addAll(list);
            }
        time += maxHeap.isEmpty() ? tasksInCycle : n + 1;
    }
    return time;
    }
}

class Pair{
    char ch;
    int freq;

    public Pair(char ch, int f){
        this.ch = ch;
        this.freq = f;
    }
}
