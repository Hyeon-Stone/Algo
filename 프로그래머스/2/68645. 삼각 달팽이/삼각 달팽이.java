class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        
        while (true) {
            // 아래로 진행
            while (true) {
                snail[y][x] = v++;
                if (y+1 == n || snail[y+1][x] != 0) {
                    break;
                }
                y += 1;
            }
            // 오른쪽으로 갈 수 없다면 Stop
            if (x + 1 == n || snail[y][x+1] != 0) {
                break;
            }
            // 오른쪽으로 가기
            x += 1;
            while (true) {
                snail[y][x] = v++;
                if (x+1 == n || snail[y][x + 1] != 0) {
                    break;
                }
                x += 1;
            }
            // 위로 갈 수 없다면 Stop
            if (snail[y-1][x-1] != 0) {
                break;
            }
            // 위로 가기
            x -= 1;
            y -= 1;
            while (true) {
                snail[y][x] = v++;
                if (snail[y-1][x-1] != 0) {
                    break;
                }
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || snail[y + 1][x] != 0) {
                break;
            }
            y += 1;
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