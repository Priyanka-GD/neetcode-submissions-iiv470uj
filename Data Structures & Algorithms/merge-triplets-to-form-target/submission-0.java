class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int answer[] = new int[3];

        for(int triplet[] : triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] &&
                triplet[2] <= target[2]){
                    answer = new int[]{Math.max(answer[0], triplet[0]),
                        Math.max(answer[1], triplet[1]),
                        Math.max(answer[2], triplet[2])};
                }
        }
        return target[0] == answer[0] && target[1] == answer[1] &&
            target[2] == answer[2];
    }
}
