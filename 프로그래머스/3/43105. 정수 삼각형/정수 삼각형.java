import java.lang.Math;
import java.util.Arrays;
class Solution {
    public int solution(int[][] triangle) {        
        return topDown(triangle);
    }
    
    private int buttomUp(int[][] triangle) {
        for (int i = triangle.length -1 ; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length-1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }
    
    private int topDown(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j ++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j == triangle[i].length-1) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }        
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}