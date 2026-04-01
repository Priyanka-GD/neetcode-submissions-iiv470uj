class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int answer[] = new int[len - k + 1];

        for(int idx = 0; idx < k; idx++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[idx]){
                deque.pollLast();
            }
            deque.addLast(idx);
        }

        int ansIdx = 0;
        answer[ansIdx++] = nums[deque.peekFirst()];

        for(int idx = k; idx < len; idx++){
            if (deque.peekFirst() == idx - k)
                deque.pollFirst();
            while(!deque.isEmpty() && 
                nums[deque.peekLast()] <= nums[idx]){
                    deque.pollLast();
            }
            deque.addLast(idx);
            answer[ansIdx++] = nums[deque.peekFirst()];
        }
        return answer;
    }
}
