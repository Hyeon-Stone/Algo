import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> completionMap = new HashMap<>();
        for (String player : completion) {
            completionMap.put(player, completionMap.getOrDefault(player, 0)+1);
        }
        
        for (String player : participant) {
            int cnt = completionMap.getOrDefault(player, 0);
            if (cnt == 0) {
                return player;
            }
            completionMap.put(player, cnt-1);
        }
        return null;
    }
}