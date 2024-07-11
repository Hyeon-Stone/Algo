import java.lang.Math;
import java.util.*;
class Solution {
    private static int answer = 0;
    Map<Integer, List<Integer>> nodeMap = new HashMap<>();
    public int solution(int n, int[][] lighthouse) {
        for (int[] light : lighthouse) {
            List<Integer> firstNode = nodeMap.getOrDefault(light[0], new ArrayList<>());
            firstNode.add(light[1]);
            nodeMap.put(light[0], firstNode);
            List<Integer> secondNode = nodeMap.getOrDefault(light[1], new ArrayList<>());
            secondNode.add(light[0]);
            nodeMap.put(light[1], secondNode);
        }
        
        dfs(1, 0);
        return answer;
    }
    
    private Integer dfs(int currentNode, int beforeNode) {
        List<Integer> subNodeGraph = nodeMap.get(currentNode);
        Integer size = subNodeGraph.size();
        if (subNodeGraph.size() == 1 && subNodeGraph.get(0) == beforeNode) {
            return 1;
        }
        
        Integer res = 0;
        for (Integer nextNode : subNodeGraph) {
            if (nextNode == beforeNode) {
                continue;
            }   
            res += dfs(nextNode, currentNode);
        }
        
        if (res == 0) {
            return 1;
        }
        
        answer++;
        return 0;
    }
}

