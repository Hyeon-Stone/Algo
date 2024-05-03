import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = maps.length;
        int m = maps[0].length;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0, 0));
        
        while(!queue.isEmpty()) {
            List<Integer> xy = queue.poll();
            Integer x = xy.get(0);
            Integer y = xy.get(1);
            for (int i = 0; i < 4; i++) {
                Integer nx = x + dx[i];
                Integer ny = y + dy[i];
                if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1) {
                    continue;
                }
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] +1;
                    queue.offer(List.of(nx, ny));
                }
                
            }
        }
        
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}