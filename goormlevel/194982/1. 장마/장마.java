import java.io.*;
import java.util.*;
class Main {
	private static int n;
	private static int m;
	private static int[] height;
	private static int[] rainDay;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		height = new int[n+1];
		rainDay = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <n+1; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int j = 1; j <m+1; j++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int k = s; k <=e; k++) {
				height[k]++;
				rainDay[k] = j;
			}
			
			if (j % 3 == 0) {
				for (int l = 1; l < n+1; l++) {
					if (rainDay[l] >= j -2) {
						height[l]--;
					}
				}
			}
		}
		for (int h =1; h < n+1; h++) {
			if (h == n) {
				System.out.print(height[h]);	
			} else {
				System.out.print(height[h] + " ");
			}
		}

	}
}