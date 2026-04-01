class Solution {
    List<List<Integer>> listOfCombinations = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        findCombinations(0, nums, target, new ArrayList<>());
        return listOfCombinations;
    }

    private void findCombinations(int start, int[] nums, int target, 
        List<Integer> list){
        if(target < 0)
            return;
        if(target == 0){
           listOfCombinations.add(new ArrayList<>(list));
           return; 
        }
        for(int idx = start; idx < nums.length; idx++){
            list.add(nums[idx]);
            findCombinations(idx, nums, target - nums[idx], list);
            list.remove(list.size() - 1);
        }
    }
}
