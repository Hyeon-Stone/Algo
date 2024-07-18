import java.io.*;
import java.util.*;
class Main {
	private static Map<Character, Character> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());
		fillMap();
		for (int i = 0; i < N; i++) {
			String origin = br.readLine();
			char[] arr = origin.toCharArray();
			StringBuilder sb = new StringBuilder();
			String print = "Mirror";
			for (int j = 0; j < arr.length; j++) {
				Character ch = map.get(arr[j]);
				if (ch == null) {
					print = "Normal";
					break;
				}
				
				sb.append(ch);
			}
			
			if (print.equals("Mirror") && sb.reverse().toString().equals(origin)) {
				System.out.println("Mirror");
			} else {
				System.out.println("Normal");
			}
		}
	}
	
	private static void fillMap() {
		map.put('b', 'd');
		map.put('d', 'b');
		map.put('i', 'i');
		map.put('l', 'l');
		map.put('m', 'm');
		map.put('n', 'n');
		map.put('o', 'o');
		map.put('p', 'q');
		map.put('q', 'p');
		map.put('s', 'z');
		map.put('z', 's');
		map.put('u', 'u');
		map.put('v', 'v');
		map.put('w', 'w');
		map.put('x', 'x');
	}
}