class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return combinations;
    }

    private void backtrack(int[] nums, List<Integer> combination) {
        if (combination.size() == nums.length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for(int num : nums) {
            if(!combination.contains(num)){
                combination.add(num);
                backtrack(nums, combination);
                combination.remove(combination.size() - 1);
            }   
        }
    }
}
