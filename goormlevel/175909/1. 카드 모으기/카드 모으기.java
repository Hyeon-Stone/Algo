import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		
		int answer = -1;
		for (int i = 0; i < M; i++) {
			set.add(Integer.parseInt(br.readLine()));
			if (set.size() == N) {
				answer = i+1;
				break;
			}
		}
		
		System.out.println(answer);
	}
}