import java.lang.Math;
import java.util.*;
import java.util.stream.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        List<Integer> timesList = Arrays
            .stream(times).boxed()
            .collect(Collectors.toList());
        long left = 1;
        long right = Collections.max(timesList) * (long)n;
        long mid = 0;
        long people = 0;
        
        while (left <= right) {
            mid = (left + right)/2;
            people = 0;
            
            for (Integer time : timesList) {
                people += mid / time;
                if (people >= n) {
                    break;
                }
            }
            
            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}