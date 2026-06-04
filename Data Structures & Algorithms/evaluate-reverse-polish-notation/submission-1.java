class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = 0;
        for (String str : tokens) {
            try {
                int num = Integer.parseInt(str);
                stack.push(num);
            } catch (NumberFormatException e) {
                a = stack.pop();
                b = stack.pop();
                
                if (str.equals("+")) {
                    stack.push(a + b);
                } else if (str.equals("-")) {
                    stack.push(b - a);
                } else if (str.equals("*")) {
                    stack.push(a * b);
                } else if (str.equals("/")) {
                    stack.push(b / a);
                }
            }
        }

        return stack.pop();
    }
}
