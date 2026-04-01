class Solution {

    public String encode(List<String> strs) {
        StringBuilder finalStr = new StringBuilder();
        for(String str : strs){
            finalStr.append(str.length()).append("#").append(str);
        }
        return finalStr.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while(idx < str.length()){
            //This searches the string starting at or after index i
            int hashIdx = str.indexOf("#", idx);
            int length = Integer.parseInt(str.substring(idx, hashIdx));
            idx = hashIdx + 1;
            result.add(str.substring(idx, idx + length));
            idx += length; 
        }
        return result;
    }
}
