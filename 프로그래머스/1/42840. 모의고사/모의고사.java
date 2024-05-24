import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i%5]) score[0] ++;
            if (answers[i] == second[i%8]) score[1] ++;
            if (answers[i] == third[i%10]) score[2] ++;
        }
        
        int max = Arrays.stream(score).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            if (score[j] == max) {
                answer.add(j+1);
            }
        }
        return answer.stream().mapToInt(n -> n).toArray();
    }
}