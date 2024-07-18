import java.io.*;
import java.util.*;
class Main {
	private static Map<Integer, List<Integer>> graph = new HashMap<>();
	private static boolean[] visited;
	private static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			List<Integer> aMap = graph.getOrDefault(a, new ArrayList<>());
			List<Integer> bMap = graph.getOrDefault(b, new ArrayList<>());
			aMap.add(b);
			bMap.add(a);
			graph.put(a, aMap);
			graph.put(b, bMap);
		}
		
		bfs();
		for (boolean a : visited) {
			if (a) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			Integer currentNode = queue.poll();
			visited[currentNode] = true;
			
			for (Integer nextNode : graph.getOrDefault(currentNode, new ArrayList<>())) {
				if (!visited[nextNode]) {
					queue.add(nextNode);
				}
			}
		}
	}
}