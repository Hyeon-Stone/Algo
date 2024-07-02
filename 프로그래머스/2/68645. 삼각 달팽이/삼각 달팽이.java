class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        
        while (true) {
            snail[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || snail[ny][nx] != 0) {
                d = (d+1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || snail[ny][nx] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }
        
        int index = 0;
        int[] answer = new int[v -1];
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j <= i; j ++) {
                answer[index++] = snail[i][j];
            }
        }
        
        return answer;
    }
}