class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // using nlogn maxHeap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair2.value - pair1.value);

        for (int idx = 0; idx < k; idx++) {
            maxHeap.add(new Pair(nums[idx], idx));
        }
        int[] answer = new int[nums.length - k + 1];
        int index = 0;
        answer[index++] = maxHeap.peek().value;

        for (int idx = k; idx < nums.length; idx++) {
            while (!maxHeap.isEmpty() && maxHeap.peek().idx < idx - k + 1) {
                maxHeap.poll();
            }
            maxHeap.add(new Pair(nums[idx], idx));
            answer[index++] = maxHeap.peek().value;
        }
        return answer;
    }
}

class Pair {
    int value;
    int idx;

    public Pair(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}
