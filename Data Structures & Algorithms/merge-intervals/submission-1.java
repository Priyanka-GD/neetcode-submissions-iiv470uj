class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (intrvl1, intrvl2) -> intrvl1[0] - intrvl2[0]);
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        List<int[]> result = new ArrayList<>();

        for(int idx = 1; idx < intervals.length; idx++){
            if(intervals[idx][0] <= currEnd){
                currEnd = Math.max(currEnd, intervals[idx][1]);
            }else{
                result.add(new int[]{currStart, currEnd});
                currStart = intervals[idx][0];
                currEnd = intervals[idx][1];
            }
        }
        result.add(new int[]{currStart, currEnd});
        return result.toArray(new int[result.size()][2]);

    }
}


// [1,3] [1,5] 


// sort all the intervals based on 0 index
// Pick up the previous = [1,3]

// iterate :
// current [1,5] => 
//    if (previous[1] >= current[0]) 


/// {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};


/// [2,29], [36,45]


