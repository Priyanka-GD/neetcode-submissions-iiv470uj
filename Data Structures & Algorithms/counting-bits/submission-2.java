class Solution {
    public int[] countBits(int n) {
       int[] count = new int[n+1];

       while(n >= 0){
        int currNum = n;
        int countOneBits = 0;
        //Anding n and n-1, transforms n's least significant 1 bit to zero,
        //So we check until num turns 0
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
