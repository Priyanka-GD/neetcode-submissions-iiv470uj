class Solution {

    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for(String str : strs){
            string.append(str.length());
            string.append("#");
            string.append(str);
        }
        return string.toString();
    }

    public List<String> decode(String str) {
        List<String> answer = new ArrayList<>();
        int idx = 0, len = 0;
        while(idx < str.length()){
            while(str.charAt(idx) != '#')
                idx++;
            int wordLen = Integer.parseInt(str.substring(len, idx));
            String string = str.substring(idx + 1, idx + wordLen + 1);
            answer.add(string);
            idx += wordLen + 1;
            len = idx;
        }
        return answer;
    }
}
