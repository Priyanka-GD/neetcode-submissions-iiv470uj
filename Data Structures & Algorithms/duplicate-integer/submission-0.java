class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(!seen.contains(num))
                seen.add(num);
            else
                return true;
        }
        return false;
    }
}
