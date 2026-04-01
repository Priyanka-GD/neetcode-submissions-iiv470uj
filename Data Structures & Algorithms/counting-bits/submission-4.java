class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for(int num = 0; num <= n; num++){
            answer[num] = getOneCount(num);
        }
        return answer;
    }
    private int getOneCount(int num){
        int count = 0;
        while(num > 0){
            if(num % 2 != 0)
                count++;
            num = num / 2;
        }
        return count;
    }
}
