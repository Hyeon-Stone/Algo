import java.io.*;
import java.util.*;
import java.lang.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.printf("%.2f", Math.floor((double) (N * 7 / 100) / (N+M) * 100 * 100) / 100);
	}
}