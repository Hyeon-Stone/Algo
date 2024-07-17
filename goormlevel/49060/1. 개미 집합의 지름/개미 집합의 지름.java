import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(house);
		
		int start = 0;
		int end = 0;
		int maxAnts = 0;
		
		while (start < N && end < N) {
			int length = house[end] - house[start];
			int numOfAnts = end - start +1;
			
			if (length <= D) {
				if (maxAnts < numOfAnts) {
					maxAnts = numOfAnts;
				} 
				end++;
			} else {
					start++;
			}
		}
		
		System.out.println(N - maxAnts);
	}
}