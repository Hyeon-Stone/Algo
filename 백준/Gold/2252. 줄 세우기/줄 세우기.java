import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int[] cntList;
    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cntList = new int[n+1];

        // 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> aMap = graph.getOrDefault(a, new ArrayList<>());
            aMap.add(b);
            graph.put(a, aMap);
            cntList[b]++;
        }

        wisang();
    }

    private static void wisang() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (cntList[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 0; i < n; i++) {
            Integer currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (Integer next : graph.getOrDefault(currentNode, new ArrayList<>())) {
                cntList[next]--;
                if (cntList[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}