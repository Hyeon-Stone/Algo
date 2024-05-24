import java.util.*;
import java.lang.Math;

class Solution {
    boolean[] checkAlreadyClear = new boolean[8];
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int dungeonsSize = dungeons.length;
        for(int i =0; i< dungeonsSize; i++) {
            if (dungeons[i][0] <= k) {
                checkAlreadyClear[i] = true;
                answer = Math.max(dfs(k-dungeons[i][1], dungeons, 1), answer);
                checkAlreadyClear[i] = false;
            }
        }
        
        return answer;
    }
    
    private Integer dfs(int k, int[][] dungeons, int answer) {
        int temp = answer;
        for (int i = 0; i < dungeons.length; i++) {
            if (!checkAlreadyClear[i] && dungeons[i][0] <= k) {
                checkAlreadyClear[i] = true;
                answer = Math.max(dfs(k-dungeons[i][1], dungeons, temp+1), answer);
                checkAlreadyClear[i] = false;
            }   
        }
        return answer;
    }
}