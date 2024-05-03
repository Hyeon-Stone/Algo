import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> line = new HashMap<>();
        for (int[] vertex : edge) {
            int node1 = vertex[0];
            int node2 = vertex[1];
            List<Integer> connectNodeList1 = line.getOrDefault(node1, new ArrayList<>());
            List<Integer> connectNodeList2 = line.getOrDefault(node2, new ArrayList<>());
            connectNodeList1.add(node2);
            connectNodeList2.add(node1);
            line.put(node1, connectNodeList1);
            line.put(node2, connectNodeList2);
        }
        
        Queue<List<Integer>> queue = new LinkedList<>(); 
        queue.offer(Arrays.asList(1,0));
        boolean[] visited = new boolean[n];
        int maxDepth = 0;
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            List<Integer> node = queue.poll();
            Integer nodeNum = node.get(0);
            Integer nodeDepth = node.get(1);

            if (maxDepth == nodeDepth) {
                answer += 1;
            } else if (maxDepth < nodeDepth) {
                maxDepth = nodeDepth;
                answer = 1;
            }
            
            for (Integer nextNodeNum :  line.get(nodeNum)) {
                if (!visited[nextNodeNum-1]) {
                    queue.offer(Arrays.asList(nextNodeNum, nodeDepth+1));
                    visited[nextNodeNum-1] = true;
                }
            }
        }
        
        return answer;
    }
}