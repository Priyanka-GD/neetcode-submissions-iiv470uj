class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>(); // Stores indices of useful elements in decreasing order
        List<Integer> res = new ArrayList<>();  // Stores the result

        // Process first 'k' elements to initialize the deque
        for (int i = 0; i < k; i++) {
            // Remove elements from the back that are smaller than the current element
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        // Add the maximum for the first window
        res.add(nums[dq.peekFirst()]);

        // Process remaining elements from index 'k' to 'nums.length - 1'
        for (int i = k; i < nums.length; i++) {
            // Remove elements that are out of the current window (left boundary)
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            // Remove all elements smaller than the current element (they won’t be needed)
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // Add the current element's index
            dq.addLast(i);
            // The front of the deque always has the max element for the current window
            res.add(nums[dq.peekFirst()]);
        }

        // Convert the result list to an array and return
        return res.stream().mapToInt(i -> i).toArray();
    }
}
