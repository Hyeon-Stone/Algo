import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int[] cntList;
    private static int[] timeList;
    private static int[] resList;
    private static int n;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        cntList = new int[n+1];
        timeList = new int[n+1];
        resList = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            timeList[i] = Integer.parseInt(st.nextToken());
            int nodeCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nodeCnt; j++) {
                List<Integer> aMap = graph.getOrDefault(i, new ArrayList<>());
                Integer nextNode = Integer.parseInt(st.nextToken());
                aMap.add(nextNode);
                graph.put(i, aMap);
                cntList[nextNode]++;
            }
        }

        topologicalSort();
        for (int res : resList) {
            if (answer < res) {
                answer = res;
            }
        }

        System.out.print(answer);
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n+1; i++) {
            resList[i] = timeList[i];
            if (cntList[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer next : graph.getOrDefault(node, new ArrayList<>())) {
                resList[next] = Math.max(resList[next], resList[node] + timeList[next]);
                cntList[next]--;

                if (cntList[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}