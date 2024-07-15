class Solution {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] answer;
    public int[][] solution(int n) {
        answer = new int[n][n];
        int value = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        answer[0][0] = 1;
        for (int i = 0; i <n*n; i++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0<=nx && nx < n && 0<=ny && ny < n ) {
                if (answer[ny][nx] == 0) {
                    answer[ny][nx] = answer[y][x] + 1;
                    x = nx;
                    y = ny;
                } else{
                    d = (d+1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if (0<=nx && nx < n && 0<=ny && ny < n ) {
                        if (answer[ny][nx] == 0) {
                            answer[ny][nx] = answer[y][x] + 1;
                            x = nx;
                            y = ny;
                        }
                    }
                }
            } else {
                d = (d+1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if (0<=nx && nx < n && 0<=ny && ny < n ) {
                        if (answer[ny][nx] == 0) {
                            answer[ny][nx] = answer[y][x] + 1;
                            x = nx;
                            y = ny;
                        }
                    }
            }
        }
            
        return answer;
    }
    
    
}