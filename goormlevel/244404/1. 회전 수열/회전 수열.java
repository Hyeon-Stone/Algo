import java.io.*;
import java.util.*;
class Main {
	private static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
	 	st = new StringTokenizer(br.readLine());
		for (int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i = 0; i < M; i++) {
			answer+=arr[answer] % N;
			if (answer > arr.length-1) {
				answer -= arr.length;
			}
		}
		
		System.out.println(arr[answer]);
	}
}