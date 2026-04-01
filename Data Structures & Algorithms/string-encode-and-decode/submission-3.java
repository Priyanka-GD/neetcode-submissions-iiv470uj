class Solution {
    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for (String str : strs) {
            string.append(str.length());
            string.append("#");
            string.append(str);
        }
        return string.toString();
    }

    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int len = 0, start = 0;

        while (start < s.length()) {
            while (s.charAt(start) != '#')
                start++;

            int lenOfPart = Integer.parseInt(s.substring(len, start));
            list.add(s.substring(start + 1, start + lenOfPart + 1));
            start += lenOfPart + 1;
            len = start;
        }
        return list; 
    }
}
