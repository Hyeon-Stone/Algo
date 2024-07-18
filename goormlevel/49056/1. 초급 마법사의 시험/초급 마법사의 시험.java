import java.io.*;
import java.util.*;
class Main {
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int[][] map;
	private static boolean[][][] visited;
	private static int R;
	private static int C;
	private static int K;
	private static int answer;
	
	private static class Location{
		int x;
		int y;
		int cnt;
		int mana;
		
		public Location(int x, int y,  int mana, int cnt) {
			this.x = x;
			this.y = y;
			this.mana = mana;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C][K+1];
		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (arr[j] == '0') {
					map[i][j] = 0;	
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(0,0,K, 0));
		visited[0][0][K] = true;
		
		while(!queue.isEmpty()) {
			Location location = queue.poll();
			int x = location.x;
			int y = location.y;
			int cnt = location.cnt;
			int mana = location.mana;
			
			if (x == R-1 && y == C-1) {
				return cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}
				
				if (visited[nx][ny][mana]) {
					continue;
				}
				
				if (map[nx][ny] == 1 && mana < 10) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
						visited[nx][ny][mana] = true;
						queue.offer(new Location(nx, ny, mana, cnt+1));
				} else {
					int nnx = nx + dx[i];
					int nny = ny + dy[i];
					if (nnx < 0 || nnx >= R || nny < 0 || nny >= C) {
						continue;
					}
					if (map[nnx][nny] == 0) {
						visited[nnx][nny][mana-10] = true;
						queue.offer(new Location(nnx, nny, mana-10, cnt+1));
					}
				}
			}
		}
		return -1;
	}
	
}