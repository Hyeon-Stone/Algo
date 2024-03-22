import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
class Solution {
    public int solution(int N, int number) {
        Map<Integer, Integer> cases = new HashMap<>();
        for (int i = N, digit = 1; digit < 9; i = i *10 + N, digit++) {
            cases.put(i, digit);
        }
        resulsionSolve(N, 0, 0, cases);
        return cases.getOrDefault(number, -1);
    }
    
    private void resulsionSolve(int N, Integer rtn, Integer value, Map<Integer, Integer> cases) {
        if (rtn > 8 || (value == 0 && rtn > 0)) {
            return;
        }
        
        cases.put(value, Math.min(cases.getOrDefault(value, rtn), rtn));
        
        for (int i = N, digit = 1; digit < 9; i = i *10 + N, digit++) {
            resulsionSolve(N, rtn+digit, value+i, cases);
            resulsionSolve(N, rtn+digit, value-i, cases);
            resulsionSolve(N, rtn+digit, value*i, cases);
            resulsionSolve(N, rtn+digit, value/i, cases);
        }
    }
}