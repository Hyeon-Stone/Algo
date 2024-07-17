class Solution {
    private static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        return dfs(k, dungeons, 0);
    }
    
    private static int dfs(int k, int[][] dangeons, int answer) {
        int temp = answer;
        for (int i = 0; i < dangeons.length; i++) {
            if (!visited[i] && dangeons[i][0] <= k) {
                visited[i] = true;
                answer = Math.max(dfs(k-dangeons[i][1], dangeons, temp+1), answer);
                visited[i] = false;
            }
        }
        
        return answer;
    }
}