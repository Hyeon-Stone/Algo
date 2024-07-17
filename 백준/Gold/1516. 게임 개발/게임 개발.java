import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int[] cntList;
    private static int[] timeList;
    private static int[] resList;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        timeList = new int[n+1];
        cntList = new int[n+1];
        resList = new int[n+1];

        for (int i =1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            timeList[i] = Integer.parseInt(st.nextToken());
            resList[i] = timeList[i];
            while (true) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) {
                    break;
                }

                List<Integer> aMap = graph.getOrDefault(input, new ArrayList<>());
                aMap.add(i);
                graph.put(input, aMap);
                cntList[i]++;
            }
        }

        topologicalSort();
        for (int i = 1; i < n+1; i++) {
            System.out.println(resList[i]);
        }
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (cntList[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            for (Integer next : graph.getOrDefault(currentNode, Collections.emptyList())) {
                resList[next] = Math.max(resList[next], resList[currentNode] + timeList[next]);
                cntList[next]--;

                if (cntList[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}