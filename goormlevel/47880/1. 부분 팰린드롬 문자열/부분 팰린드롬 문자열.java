import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int length = input.length;
		
		for (int i = length; i >= 1; i--) {
			for (int start = 0; start+i <= length; start++) {
				boolean check = true;
				
				for (int k = 0; k < i /2; k++) {
					if (input[start + k] != input[start + i  - k - 1]) {
						check = false;
						break;
					}
				}
				
				if (check) {
					System.out.println(i);
					return;
				}
			}
		}
		
	}
}