class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[nums.length - k + 1];
        int index = 0;
        for (int idx = 0; idx < k; idx++) {
            while (!deque.isEmpty() && nums[idx] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.add(idx);
        }
        answer[index++] = nums[deque.peekFirst()];
        for (int idx = k; idx < nums.length; idx++) {
            if (deque.peekFirst() == idx - k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[idx] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.add(idx);
            answer[index++] = nums[deque.peekFirst()];
        }
        return answer;
    }
}
