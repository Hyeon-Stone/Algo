import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stackInt = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        for (Integer i = 0; i < arr.length; i++) {
            if (stackInt.isEmpty()) {
                stackInt.push(arr[i]);
            }
            
            Integer stackTop = stackInt.pop();
            if (stackTop != arr[i]) {
                answer.add(stackTop);
            }
            stackInt.push(arr[i]);
        }
        answer.add(stackInt.pop());

        return answer.stream().mapToInt(n->n).toArray();
    }
}