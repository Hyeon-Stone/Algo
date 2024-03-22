class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int [][] map = new int[n+1][m+1];
        
        if (puddles.length != 0) {
            for (int[] puddle : puddles) {
                map[puddle[1]][puddle[0]] = -1;
            }
        }
        
        for(int i = 2 ;i < n+1; i++){
            map[i][1] = (map[i][1] == -1 | map[i-1][1] == -1) ? -1 : 1;
        }
        
        for(int j = 2 ;j < m+1; j++){
            map[1][j] = (map[1][j] == -1 | map[1][j-1] == -1) ? -1 : 1;
        }
        
        for (int i = 2; i < n+1; i++) {
            for (int j = 2; j <m+1; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                
                int a = map[i-1][j] == -1 ? 0 : map[i-1][j];
                int b = map[i][j-1] == -1 ? 0 : map[i][j-1];   
                map[i][j] = (a+b) == 0 ? -1 : (a+b) % 1000000007;
            }
        }
        
        return map[n][m] == -1 ? 0 : map[n][m];
    }
}