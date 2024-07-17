import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i =0; i < N ; i++) {
			int[] a = new int[4];
			int[] b = new int[4];
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int k = 0; k < cnt; k++) {
				int card = Integer.parseInt(st.nextToken());
				if (card == 4) {
					a[0]++;
				}else if (card == 3) {
					a[1]++;
				} else if (card == 2) {
					a[2]++;
				} else {
					a[3]++;
				}
			}
			
			
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for (int k = 0; k < cnt; k++) {
				int card = Integer.parseInt(st.nextToken());
				if (card == 4) {
					b[0]++;
				}else if (card == 3) {
					b[1]++;
				} else if (card == 2) {
					b[2]++;
				} else {
					b[3]++;
				}
			}
			
			String answer = "";
			for (int p = 0; p < 4; p++) {
				if (answer != "") {
					continue;
				}
				
				if (a[p] > b[p]) {
					answer = "A";
					break;
				} else if (a[p] < b[p]) {
					answer = "B";
					break;
				}
			}
			
			if (answer == "") {
				System.out.println("D");
			} else {
				System.out.println(answer);
			}
		}
		System.out.println();
	}
}