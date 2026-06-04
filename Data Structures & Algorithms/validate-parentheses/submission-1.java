class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if(stack.empty() || !match(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private boolean match(char open, char close) {
        boolean result = false;
        if (open == '(' && close == ')') result = true;
        else if (open == '[' && close == ']') result = true;
        else if (open == '{' && close == '}') result = true;
        return result;
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}
