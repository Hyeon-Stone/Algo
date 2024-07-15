import java.util.Arrays;
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day = 0;
        while (day+10 <= discount.length) {
            boolean check = true;
            for (int i =0; i < want.length; i++) {
                if (!checkCount(want[i], number[i], Arrays.copyOfRange(discount, day, day+10))) {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                answer++;
            }
            
            day++;
        }
        
        return answer;
    }
    
    private boolean checkCount(String want, int number, String[] array ) {
        int count = 0;
        for (String fruit : array) {
            if (want.equals(fruit)) {
                count++;
            }
        }
        
        return count == number;
    }
}