class Solution {
    Set<Integer> seen = new HashSet<>();
    public boolean isHappy(int n) {
        while(n > 0){
            int number = getNum(n);
            if(number == 1)
                return true;
            if(seen.contains(number))
                return false;
            seen.add(number); 
            n = number;
        }
        return false; 
    }
    private int getNum(int num){
        int sum = 0;
        while(num > 0){
            int n = num % 10;
            sum += Math.pow(n, 2);
            num = num / 10;
        }
        return sum;
    }
}
