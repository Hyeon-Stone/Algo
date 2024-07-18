import java.io.*;
import java.util.*;
class Main {
	private static int[] dx = {1,-1, 0,0};
	private static int[] dy = {0,0,1,-1};
	private static int[][] map;
	private static boolean[][] visited;
	private static int N;
	private static int M;
	
	private static class Obj{
		int x;
		int y;
		
		public Obj(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (arr[j] == '#') {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					cnt++;
					visited[i][j] = true;
					answer = Math.max(bfs(new Obj(i, j)), answer);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(answer);
	}
	
	private static int bfs(Obj obj) {
		Queue<Obj> queue = new LinkedList<>();
		queue.offer(obj);
		
		int size = 1;
		while(!queue.isEmpty()) {
			Obj current = queue.poll();
			int x = current.x;
			int y = current.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx > M-1 || ny < 0 ||ny > N-1) {
					continue;
				}
				
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new Obj(nx, ny));
					visited[nx][ny] = true;
					size++;
				}
			}
		}
		return size;
	}
}