import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken());
		String T = st.nextToken();
		
		for (int r =2; r <= 16; r++) {
			// if (Long.toString(N,r).equals(T)) {
			// 	System.out.println(r);	
			// 	return;
			// }
			try {
				if (new BigInteger(T, r).compareTo(N) == 0) {
					System.out.println(r);	
					return;
				}
			} catch (Exception e){
				continue;
			}
		}
	}
}