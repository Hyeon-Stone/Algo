import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		
		String binary = N.toString(2);
		
		char[] arr = binary.toCharArray();
		StringBuilder sb = new StringBuilder();
		int cnt = 0;		
		for (int i=arr.length-1; i >= 0; i--) {
			if (arr[i] == '1') {
				cnt++;
				sb.append(arr.length-i-1).append(" ");	
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(cnt);
		System.out.print(sb.toString());
	}
}