class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s : strs){
            str.append(s.length()).append("#").append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        
        int idx = 0;
        while(idx < str.length()){
            int splitIdx = str.indexOf("#");
            int strLen = Integer.parseInt(str.substring(idx, splitIdx));
            result.add(str.substring(splitIdx + 1, splitIdx + 1 + strLen));
            str = str.substring(splitIdx + 1 + strLen);
        }
        return result;
    }
}
