class Solution {
    public String longestCommonPrefix(String[] strs) {
        return getCommonPrefix(strs);
    }
    public String getCommonPrefix(String[] strs){
        StringBuilder res = new StringBuilder();
        String firstStr = strs[0];
        for(int idx = 0; idx < firstStr.length(); idx++){
            char ch = firstStr.charAt(idx);
            for(int i = 1; i < strs.length; i++){
                if(idx >= strs[i].length() || strs[i].charAt(idx) != ch){
                    return res.toString();
                }
            }
            res.append(ch);
        }
        return res.toString();
    }
}