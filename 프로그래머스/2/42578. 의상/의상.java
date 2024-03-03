import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothsMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothsMap.put(cloth[1], clothsMap.getOrDefault(cloth[1], 0)+1);
        }
        
        Integer answer = 1;
        for(Integer value : clothsMap.values()) {
			answer *= value +1;
		}
        
        return answer -1;
    }
}