class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Task> map = new HashMap<>();
        for (char task : tasks) {
            if (map.containsKey(task)) {
                Task fetchedTask = map.get(task);
                fetchedTask.updateFreq();
                map.put(task, fetchedTask);
            } else {
                map.put(task, new Task(task));
            }
        }

        PriorityQueue<Task> maxHeap = new PriorityQueue<>(
                (task1, task2) -> task2.freq - task1.freq);
        for (Task task : map.values()) {
            maxHeap.add(task);
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Task> pendingTasks = new ArrayList<>();
            int count = n + 1, taskCompleted = 0;
            ;
            while (count-- > 0 && !maxHeap.isEmpty()) {
                Task currTask = maxHeap.poll();
                currTask.freq--;
                if (currTask.freq > 0) {
                    pendingTasks.add(currTask);
                }
                taskCompleted++;
            }
            maxHeap.addAll(pendingTasks);
            time += maxHeap.isEmpty() ? taskCompleted : n + 1;
        }
        return time;

    }
}

class Task {
    char taskChar;
    int freq;

    public Task(char ch) {
        this.taskChar = ch;
        this.freq = 1;
    }

    public void updateFreq() {
        this.freq++;
    }
}
