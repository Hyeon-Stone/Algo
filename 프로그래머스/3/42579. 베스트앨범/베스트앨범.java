import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, HashMap<Integer, Integer>> playsPerGenreMap = new HashMap<>();
        HashMap<String, Integer> totalPlayCountMap = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            Integer play = plays[i];
            HashMap<Integer, Integer> playIndexMap = playsPerGenreMap.getOrDefault(genre, new HashMap<>());
            playIndexMap.put(i, play);
            playsPerGenreMap.put(genre, playIndexMap);
            
            totalPlayCountMap.put(genre, totalPlayCountMap.getOrDefault(genre, 0) + play);
        }
        
        List<String> playMapKeyList = new ArrayList<>(playsPerGenreMap.keySet());
        playMapKeyList.sort((o1, o2) -> (totalPlayCountMap.get(o2).compareTo(totalPlayCountMap.get(o1))));
        
        for (String key : playMapKeyList) {
            HashMap<Integer, Integer> lastPlayIndexMap = playsPerGenreMap.get(key);
            List<Integer> indexList = new ArrayList<>(lastPlayIndexMap.keySet());
            
            if (indexList.size() == 1) {
                answer.add(indexList.get(0));
                continue;
            }
            
            indexList.sort((o1, o2) -> (lastPlayIndexMap.get(o2).compareTo(lastPlayIndexMap.get(o1))));
            
            answer.add(indexList.get(0));
            answer.add(indexList.get(1));
        }
        return answer.stream().mapToInt(n -> n).toArray();
    }
}