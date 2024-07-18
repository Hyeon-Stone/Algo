import java.io.*;
import java.util.*;
class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long top = R;
			long buttom = 1;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <N; j++) {
				int percent = Integer.parseInt(st.nextToken());
				top = top * (100 - percent);
				buttom *= 100;
				
				long gcd = getGCD(top, buttom);
				top /= gcd;
				buttom /= gcd;
			}
			sb.append(top).append("/").append(buttom).append("\n");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
	
	public static long getGCD(long num1, long num2) {
		if (num1 % num2 == 0) {
				return num2;
		}
		
		return getGCD(num2, num1%num2);
	}
}