class Solution {
    public int hammingWeight(int n) {
        int countOneBit = 0;
        while(n > 0){
            if(n % 2 == 1)
               countOneBit++;
            n = n / 2;
        }
        return countOneBit;
    }
}
