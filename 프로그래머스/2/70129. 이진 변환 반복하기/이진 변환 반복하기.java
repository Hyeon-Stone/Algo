class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        while(!s.equals("1")) {
            answer[0] += 1;
            int countZero = countZero(s);
            answer[1] += countZero;
            
            s = Integer.toString(s.length() - countZero, 2);
        }
        return answer;
    }
    
    private int countZero(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        
        return count;
    }
}