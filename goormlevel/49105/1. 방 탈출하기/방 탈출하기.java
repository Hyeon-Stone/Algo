import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> arr = new HashSet<>();
		for (int i = 0; i < N; i++) {
			arr.add(st.nextToken());
		}
		
		Integer M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (arr.contains(st.nextToken())) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}