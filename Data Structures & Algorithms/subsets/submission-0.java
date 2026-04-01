class Solution {
    List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return combinations;
    }

    private void backtrack(int start, int[] nums, List<Integer> combination) {
        if (start == nums.length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        combination.add(nums[start]);
        backtrack(start + 1, nums, combination);
        combination.remove(combination.size() - 1);
        backtrack(start + 1, nums, combination);
    }

}