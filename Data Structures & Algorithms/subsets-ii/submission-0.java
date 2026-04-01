class Solution {
    List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return subsets;
    }

    private void backtrack(int start, int[] nums, List<Integer> list) {
        subsets.add(new ArrayList<>(list));
        for (int idx = start; idx < nums.length; idx++) {
            if (idx != start && nums[idx] == nums[idx - 1]) {
                continue;
            }
            list.add(nums[idx]);
            backtrack(idx + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}