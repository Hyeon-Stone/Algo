import java.io.*;
import java.util.*;
class Main {
	private static final int[] dx = {0,0,-1,1};
	private static final int[] dy = {-1,1,0,0};
	private static int X;
	private static int Y;
	private static int N;
	private static int[][] arr;
	private static String answer = "NO";
	private static class Point {
		int x;
		int y;
		int second;
		
		public Point(int x, int y, int second) {
			this.x = x;
			this.y = y;
			this.second = second;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			X = Math.abs(Integer.parseInt(st.nextToken()));
			Y = Math.abs(Integer.parseInt(st.nextToken()));
			N = Integer.parseInt(st.nextToken());
			answer = "NO";
			if (X+Y <= N && (X+Y) % 2 == N%2) answer = "YES";
			System.out.println(answer);
		}
	}
	

}