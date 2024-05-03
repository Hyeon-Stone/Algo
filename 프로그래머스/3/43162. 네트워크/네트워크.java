import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        
        for (Integer hop = 0; hop < n; hop++) {
            if (visited[hop] == 0) {
                visited = BFS(n, visited, hop, computers);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private int[] DFS(int n, int[] visited, int hop, int[][] computers) {
        visited[hop] = 1;
        for (Integer com = 0; com < n; com++) {
            if (com != hop && computers[com][hop] == 1 && visited[com] == 0) {
                visited =  DFS(n, visited, com, computers);
            }
        }
        
        return visited;
    }
    
    private int[] BFS(int n, int[] visited, int hop, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(hop);
        
        while(!queue.isEmpty()) {
            Integer a = queue.poll();
            visited[a] = 1;
            for (Integer com = 0; com < n; com++) {
                if (com != a && computers[com][a] == 1 && visited[com] == 0) {
                    visited =  BFS(n, visited, com, computers);
                }
            }
        }
        return visited;
    }
}