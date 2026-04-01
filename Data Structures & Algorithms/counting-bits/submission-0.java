class Solution {
    public int[] countBits(int n) {
       int[] count = new int[n+1];
       while(n >= 0){
        int currNum = n;
        int countOfOneBits = 0;
        while(currNum > 0){
            if(currNum % 2 != 0)
                countOfOneBits++;
            currNum /= 2;
        }
        count[n] = countOfOneBits;
        n--;
       }
        return count;
    }
}
