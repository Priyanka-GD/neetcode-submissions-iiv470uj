class Solution {
    public int[] countBits(int n) {
       int[] count = new int[n+1];

       while(n >= 0){
        int currNum = n;
        int countOneBits = 0;
        while(currNum != 0){
            currNum &= (currNum -1);
            countOneBits++;
        }
        count[n] = countOneBits;
        n--;
       }
        return count;
    }
}
