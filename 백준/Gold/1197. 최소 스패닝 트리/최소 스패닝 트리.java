import java.io.*;
import java.util.*;

public class Main {
    private static int answer = 0;
    private static boolean[] visited;
    private static Map<Integer, List<Node>> nodeMap = new HashMap<>();
    static List<Node>[] list;

    private static class Node implements Comparable<Node>{
        int toNode;
        int weight;

        public Node(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }
        // 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

//            List<Node> aMap = nodeMap.getOrDefault(a, new ArrayList<>());
//            List<Node> bMap = nodeMap.getOrDefault(a, new ArrayList<>());
            list[a].add(new Node(b,w));
            list[b].add(new Node(a,w));
//            aMap.add(new Node(b, w));
//            bMap.add(new Node(a,w));
//            nodeMap.put(a, aMap);
//            nodeMap.put(b, bMap);
        }

        prim(1);
        System.out.println(answer);
    }

    private static void prim(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (visited[currentNode.toNode]) {
                continue;
            }

            visited[currentNode.toNode] = true;
            answer+=currentNode.weight;

            for (Node child : list[currentNode.toNode]) {
                if (visited[child.toNode]) {
                    continue;
                }

                queue.offer(child);
            }
        }
    }
}