class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> pair2.val - pair1.val);

        for(int i = 0; i < k; i++){
            pq.add(new Pair(nums[i], i));
        }

        int result[] = new int[nums.length - k + 1];

        int index = 0;

        result[index++] = pq.peek().val;

        for(int i = k; i < nums.length; i++){
            while(!pq.isEmpty() && pq.peek().idx < i - k + 1){
                pq.poll();
            }
            pq.add(new Pair(nums[i], i));
            result[index++] = pq.peek().val;

        }
        return result;
    }
}
class Pair{
    int val;
    int idx;

    public Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}