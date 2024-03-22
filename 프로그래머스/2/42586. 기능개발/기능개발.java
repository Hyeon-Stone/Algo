import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            Integer day = (int) Math.ceil(((100 - (double)progresses[i]) / (double)speeds[i]));
            
            Integer len = days.size();
            if (len == 0 || (Collections.max(days) >= day)) {
                days.add(day);
            } else {
                answer.add(len);
                days.clear();
                days.add(day);
            }
        }
        
        if (days.size() != 0) {
            answer.add(days.size());
        }
        return answer.stream().mapToInt(n -> n).toArray();
    }
}