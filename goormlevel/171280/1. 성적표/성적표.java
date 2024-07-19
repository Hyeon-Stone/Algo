import java.io.*;
import java.util.*;
import java.lang.*;
class Main {
	
	// private static class Major implements Comparable<Major>{
	// 	int id;
	// 	double score;
		
	// 	public Major(int id, double score) {
	// 		this.id = id;
	// 		this.score = score;
	// 	}
		
	// 	@Override
	// 	public int compareTo(Major major) {
	// 		if (this.score > major.score) {
				
	// 		}
	// 		return this.score - major.score;
	// 	}
	// }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, List<Double>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int major = Integer.parseInt(st.nextToken());
			List<Double>scoreList = map.getOrDefault(major, new ArrayList<>());
			scoreList.add(Double.parseDouble(st.nextToken()));
			map.put(major, scoreList);
		}
		
		double top = Integer.MIN_VALUE;
		int id = Integer.MAX_VALUE;
		for (Integer key : map.keySet()) {
			List<Double> scoreList = map.get(key);
			double sum = scoreList.stream().mapToDouble(Double::doubleValue).sum();
			if (top == (sum / scoreList.size())) {
				id = Math.min(id, key);
				continue;
			} else if (top < (sum / scoreList.size())) {
				top = (sum / scoreList.size());
				id = key;
			}
		}
		
		System.out.println(id);
	}
}