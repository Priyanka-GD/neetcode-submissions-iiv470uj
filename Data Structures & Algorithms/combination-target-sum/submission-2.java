class Solution {
    Set<List<Integer>> combinations = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        getCombinationSum(nums, target, 0, 0, new ArrayList<>());
        return new ArrayList<>(combinations);
    }

    public void getCombinationSum(int[] nums, int target, int currSum, int idx, List<Integer> numbers){
        if(currSum > target)
            return;

        if(currSum == target){
            combinations.add(new ArrayList<>(numbers));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            numbers.add(nums[i]);
            getCombinationSum(nums, target, currSum + nums[i], i, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}
