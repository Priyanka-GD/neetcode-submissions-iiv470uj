class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer first = null, second = null;
        int p1 = 0, p2 = 0;
        for(int num : nums){
            if(first == null || first == num){
                first = num;
                p1++;
            }else if(second == null || second == num){
                second = num;
                p2++;
            }else if(p1 == 0){
                first = num;
                p1++;
            }else if(p2 == 0){
                second = num;
                p2++;
            }else{
                p1--;
                p2--;
            }
        }

        p1 = 0;
        p2 = 0;

        for(int num : nums){
            if(first != null && first == num){
                p1++;
            }else if(second != null && second == num){
                p2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(p1 > nums.length / 3){
            res.add(first);
        }
        if(p2 > nums.length/3){
            res.add(second);
        }
        return res;
    }
}