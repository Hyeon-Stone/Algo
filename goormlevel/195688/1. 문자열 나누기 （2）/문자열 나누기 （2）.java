import java.io.*;
import java.util.*;
class Main {
	private static int N;
	private static char[] arr;
	private static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String S = br.readLine();
	
		int maxScore = 0;
		List<String[]> arr = new ArrayList<>();
		// Generate all possible ways to split the string into three parts
		for (int i = 1; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
					String part1 = S.substring(0, i);
					String part2 = S.substring(i, j);
					String part3 = S.substring(j);
					set.addAll(List.of(part1, part2, part3));
					arr.add(new String[]{part1, part2, part3});
			}
		}
		List<String> lll = new ArrayList<>(set);
		Collections.sort(lll);
		for (String[] data : arr) {
			int score = lll.indexOf(data[0]) + lll.indexOf(data[1]) + lll.indexOf(data[2]) + 3;
			maxScore = Math.max(score, maxScore);
		}
		
		System.out.println(maxScore);
	}
}