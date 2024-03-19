import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Map<Integer, Integer>> playMap = new HashMap<>();
        
        for (Integer index = 0; index < genres.length; index++) {
            String genre = genres[index];
            Map<Integer, Integer> playIndexMap = playMap.getOrDefault(genre, new HashMap<>());
            playIndexMap.put(index, plays[index]);
            playMap.put(genre, playIndexMap);
        }
        
        Map<String, Integer> totalPalysMap = new HashMap<>();
        for (String play : playMap.keySet()) {
            totalPalysMap.put(play, playMap.get(play).values().stream().mapToInt(n->n).sum());
        }
        
        List<String> keySetList = new ArrayList<>(playMap.keySet());
        keySetList.sort((o1, o2) -> (totalPalysMap.get(o2).compareTo(totalPalysMap.get(o1))));
        
        for (String key : keySetList) {
            Map<Integer, Integer> lastPlayIndexMap = playMap.get(key);
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