import java.util.*;
class Solution {
    private static class Node implements Comparable<Node>{
        int nextNode;
        int weight;
        
        public Node(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return weight - other.weight;
        }
    }
    
    private static int answer = 0;
    private static boolean[] visited;
    private static Map<Integer, List<Node>> graph = new HashMap<>();
    public int solution(int N, int[][] road, int K) {
        visited = new boolean[N+1];
        
        for (int[] roadList : road) {
            List<Node> aList = graph.getOrDefault(roadList[0], new ArrayList<>());
            List<Node> bList = graph.getOrDefault(roadList[1], new ArrayList<>());
            aList.add(new Node(roadList[1], roadList[2]));
            bList.add(new Node(roadList[0], roadList[2]));
            graph.put(roadList[0], aList);
            graph.put(roadList[1], bList);
        }
        
        prim(1, K);
        return answer;
    }
    
    private static void prim(int start, int K) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start,0));
        
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int nextNode = currentNode.nextNode;
            int currentDistance = currentNode.weight;
            if (visited[nextNode]) {
                continue;
            }
            
            visited[nextNode] = true;
            if (currentDistance <= K) {
                answer++;
            }
            
            for (Node next : graph.get(nextNode)) {
                if (visited[next.nextNode]) {
                    continue;
                }
                next.weight = next.weight + currentDistance;
                queue.offer(next);
            }
        }
    }
}