import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        List<Integer> count = List.of(781, 156, 31, 6, 1);
        
        for (int i = 0; i < word.length(); i++) {
            Character alpha = word.charAt(i);
            Integer step = 0;
            if (alpha.equals('A')) {
                step = 0;
            } else if (alpha.equals('E')) {
                step = 1;
            } else if (alpha.equals('I')) {
                step = 2;
            } else if (alpha.equals('O')) {
                step = 3;
            } else if (alpha.equals('U')) {
                step = 4;
            }
            answer += step * count.get(i) + 1;
        }
        return answer;
    }
}