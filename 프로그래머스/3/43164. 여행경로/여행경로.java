import java.util.*;

class Solution {
        boolean[] visited;
        ArrayList<String> allRoute;

        public String[] solution(String[][] tickets) {
            String[] answer = {};
            int cnt = 0;
            visited = new boolean[tickets.length];
            allRoute = new ArrayList<>();
            Arrays.sort(tickets, (o1, o2) -> {
                return o1[1].compareTo(o2[1]);
            });
            
            dfs("ICN", "ICN", tickets, cnt);

            answer = allRoute.get(0).split(" ");

            return answer;
        }

        public void dfs(String start, String route, String[][] tickets, int cnt){
            if(cnt == tickets.length){
                allRoute.add(route);
                return;
            }

            for(int i=0; i<tickets.length; i++){
                if(start.equals(tickets[i][0]) && !visited[i]){
                    visited[i] = true;
                    dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                    visited[i] = false;
                }
            }
        }
    
}