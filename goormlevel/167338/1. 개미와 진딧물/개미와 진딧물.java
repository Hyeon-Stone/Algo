import java.io.*;
import java.util.*;
class Main {
	private static int N;
	private static int M;
	
	private static class Location {
		int x;
		int y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Location> antMap = new ArrayList<>();
		List<Location> waterMap = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String input = st.nextToken();
				if (input.equals("1")) {
					antMap.add(new Location(i,j));
				} else if (input.equals("2")) {
					waterMap.add(new Location(i,j));
				}
			}
		}
		int answer = 0;
		for (Location ant : antMap) {
			for (Location water : waterMap) {
				if ((Math.abs(ant.x - water.x) + Math.abs(ant.y - water.y)) <= M) {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}