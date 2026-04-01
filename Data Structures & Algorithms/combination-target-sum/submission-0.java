class Solution {
    Set<List<Integer>> combinations = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, nums, target, new ArrayList<>());
        return new ArrayList<>(combinations);
    }

    private void backtrack(int start, int[] nums, int target, List<Integer> list){
        if(target == 0){
            combinations.add(new ArrayList<>(list));
            return;
        }
        if(target < 0)
            return;
        for(int idx = start; idx < nums.length; idx++){
            list.add(nums[idx]);
            backtrack(idx, nums, target - nums[idx], list);
            list.remove(list.size() - 1);
        }
    }
}
