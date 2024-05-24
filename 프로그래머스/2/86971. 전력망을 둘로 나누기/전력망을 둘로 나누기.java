import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int cnt;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            graph = new ArrayList<>();
            for (int k = 0; k < n+1; k++) {
                graph.add(new ArrayList<>());
            }
            
            int x = 0;
            for(int j=0; j < wires.length; j++){
                if(j == i) {
                    continue;
                }
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
                x = a;
            }
            cnt = 1;
            visited = new boolean[n+1];
            dfs(x);
            // 두 전력망의 송전탑 차의 최솟값
            answer = Math.min(answer, Math.abs(2*cnt - n));
        }
        
        return answer;
    }
    
    public static void dfs(int x){
        visited[x] = true;
        for (Integer now : graph.get(x)) {
            if(visited[now]) continue;
            cnt++;
            dfs(now);
        }
    }
}