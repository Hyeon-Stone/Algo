import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());
		int[] cntByLevel = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 6; i++) {
			cntByLevel[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Queue<Integer>> levelMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			Queue<Integer> levelQueue = levelMap.getOrDefault(level, new PriorityQueue<>());
			levelQueue.offer(time);
			levelMap.put(level, levelQueue);
		}
		int answer  = -60;
		for (int i = 1; i < 6; i++) {
			Queue<Integer> queue = levelMap.get(i);
			int beforeTime = queue.peek();
			answer+=60;
			for (int j = 0; j < cntByLevel[i]; j++) {
				int solveTime = queue.poll();
				answer += solveTime*2 - beforeTime;
				beforeTime = solveTime;
			}
		}
		System.out.println(answer);
	}
}