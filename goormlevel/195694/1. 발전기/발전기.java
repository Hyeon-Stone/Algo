import java.io.*;
import java.util.*;
class Main {
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	private static int[][] map;
	private static boolean[][] visited;
	private static int N;
	
	private static class House {
		int x;
		int y;
		
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(new House(i,j));
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void bfs(House house) {
		Queue<House> queue = new LinkedList<>();
		queue.offer(house);
		
		while(!queue.isEmpty()) {
			House currentHouse = queue.poll();
			int x = currentHouse.x;
			int y = currentHouse.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx > N-1 || ny < 0 || ny > N-1) {
					continue;
				}
				
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new House(nx, ny));
				} 
			}
		}
	}
}