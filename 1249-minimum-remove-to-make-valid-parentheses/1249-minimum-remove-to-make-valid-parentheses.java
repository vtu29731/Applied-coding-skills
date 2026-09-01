class Solution {
public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                result.append(c);
            }
            else if (c == ')') {
                if (open > 0) {
                    open--;
                    result.append(c);
                }
            }
            else {
                result.append(c);
            }
        }
        for (int i = result.length() - 1; i >= 0 && open > 0; i--) {
            if (result.charAt(i) == '(') {
                result.deleteCharAt(i);
                open--;
            }
        }
        return result.toString();
    }
}