import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int getPoketmonSize = nums.length / 2;
		
        HashMap<Integer, Integer> poketmonTypes = new HashMap<>();
        for (int num : nums) {
            poketmonTypes.put(num, poketmonTypes.getOrDefault(num, 0) + 1);
        }
        
        int typeCnt = poketmonTypes.size();
        if (getPoketmonSize > typeCnt) {
            return typeCnt;
        }
        
        return getPoketmonSize;
    }
}