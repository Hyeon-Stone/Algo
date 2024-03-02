import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerRank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerRank.put(players[i], i);
        }
        
        for (String calling : callings) {
            int rank = playerRank.get(calling);
            
            String frontPlayer = players[rank-1];
            
            players[rank-1] = calling;
            players[rank] = frontPlayer;
            
            playerRank.put(calling, rank-1);
            playerRank.put(frontPlayer, rank);
        }
        
        return players;
    }
}