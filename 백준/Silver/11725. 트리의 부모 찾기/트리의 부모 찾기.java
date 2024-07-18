import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static boolean[] visited;
    private static int[] parentArr;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parentArr = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
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

        dfs(1);
        for ( int i = 2; i < N+1; i++) {
            System.out.println(parentArr[i]);
        }
    }

    private static void dfs(int parent) {
        visited[parent] = true;
        for (Integer next : graph.getOrDefault(parent, Collections.emptyList())) {
            if (!visited[next]) {
                parentArr[next] = parent;
                dfs(next);
            }
        }
    }
}