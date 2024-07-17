
class Solution {
    private static int answer = 0;
    private static int r = 3;
    
    public int solution(int[] number) {
        comb(number, new boolean[number.length], 0, 0);
        return answer;
    }
    
    private static void comb(int[] number, boolean[] visited, int start, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i=0; i < number.length; i++) {
                if (visited[i]) {
                    sum += number[i];
                }
            }
            if (sum == 0) {
                answer++;
            }
        }
        
        for (int i = start; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(number, visited, i, depth+1);
                visited[i] = false;
            }
        }
    }
}