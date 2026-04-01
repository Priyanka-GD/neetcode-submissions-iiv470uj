class Solution {
    public List<Integer> partitionLabels(String s) {
        int indexPosition[] = new int[26];
        int idx = 0;
        for(char ch : s.toCharArray()){
            indexPosition[ch - 'a'] = idx;
            idx++;
        }
        List<Integer> answer = new ArrayList<>();
        int maxIdx = 0, nextIdx = 0;
        for(int i = 0; i < s.length(); i++){
            maxIdx = Math.max(maxIdx,indexPosition[s.charAt(i) - 'a']);
            if(i == maxIdx){
                answer.add(i - nextIdx + 1);
                nextIdx = i + 1;
            }
        }
        return answer;
    }
}
