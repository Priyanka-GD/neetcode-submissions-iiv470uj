class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n, new StringBuilder());
        return answer;
    }
    private void backtracking(int left, int right, 
                                int n, StringBuilder string){
        if(string.length() == 2 * n){
            answer.add(string.toString());
            return;
        }
        if(left < n){
            string.append("(");
            backtracking(left + 1, right, n, string);
            string.deleteCharAt(string.length() - 1);
        }
        if(left > right){
            string.append(")");
            backtracking(left, right + 1, n, string);
            string.deleteCharAt(string.length() - 1);
        }
    }
}
