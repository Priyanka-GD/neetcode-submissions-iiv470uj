class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        while (idx < str.length()) {
            int splitIdx = str.indexOf("#");
            int partLen = Integer.parseInt(str.substring(idx, splitIdx));
            list.add(str.substring(splitIdx + 1, splitIdx + 1 + partLen));
            str = str.substring(splitIdx + 1 + partLen);
        }
        return list;
    }
}
