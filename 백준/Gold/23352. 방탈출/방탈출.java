import java.io.*;
import java.util.*;

public class Main {
    private static int cnt = Integer.MIN_VALUE;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visit;
    private static int n;
    private static int m;
    private static int start;
    private static int answer = 0;
    private static class Room {
        int x;
        int y;
        int cnt;

        public Room(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    visit = new boolean[n][m];
                    visit[i][j] = true;
                    start = arr[i][j];
                    bfs(new Room(i, j, 1));
                }
            }
        }

        System.out.print(answer);
    }

    private static void bfs(Room room) {
        Queue<Room> queue = new LinkedList<>();
        queue.add(room);
        while (!queue.isEmpty()) {
            Room currentRoom = queue.remove();
            int x = currentRoom.x;
            int y = currentRoom.y;
            int move = currentRoom.cnt;
            int end = arr[x][y];

            if (move > cnt) {
                answer = start + end;
                cnt = move;
            } else if (move == cnt) {
                answer = Math.max(answer, start+end);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < n && nx >= 0 && ny < m && ny >= 0) {
                    if (arr[nx][ny] != 0 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.add(new Room(nx, ny, move+1));
                    }
                }
            }
        }
    }
}