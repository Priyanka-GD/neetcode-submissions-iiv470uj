public class Solution {
    // we are adding strlen for string length of 1, say str = "#"
    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for (String str : strs) {
            string.append(str.length());
            string.append("#");
            string.append(str);
        }
        return string.toString();
    }

    public List<String> decode(String str) {
        List<String> answer = new ArrayList<>();
        int strIdx = 0;
        while (strIdx < str.length()) {
            int wordLenEndIdx = str.indexOf("#");
            int lenOfWord = 0;
            while(strIdx < str.length() && Character.isDigit(str.charAt(strIdx))){
                strIdx++;
                lenOfWord++;
            }
            int wordLen = Integer.parseInt(str.substring(strIdx - lenOfWord, wordLenEndIdx));
            String word = str.substring(strIdx + 1 , strIdx + wordLen + 1);
            str = str.substring(strIdx + wordLen + 1);
            strIdx = 0;
            answer.add(word);
        }
        return answer;
    }
}
