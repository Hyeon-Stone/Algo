class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int total = brown + yellow;
        
        for (int w = total-1; w > 0; w--) {
            if (total % w != 0 ) {
                continue;
            }
            
            int h = total / w;
            int y = (w - 2) * (h - 2);
            int b = total - y;
            
            if (y == yellow && b == brown) {
                answer[0] = w;
                answer[1] = h;
                return answer;
            }
        }
        return answer;
    }
}