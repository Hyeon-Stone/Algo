import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.empty()) return false;
                else {
                    stack.pop();
                    continue;
                }
            }
            
            stack.push(s.charAt(i));
        }
        
        return stack.empty();
    }
}