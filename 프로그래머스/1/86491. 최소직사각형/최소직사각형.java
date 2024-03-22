class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int xMax = 0;
        int yMax = 0;
        
        for (int[] size : sizes) {
            int x = size[0];
            int y = size[1];
            if (x < y) {
                int temp = x;
                x = y;
                y = temp;
            }
            
            if (xMax < x) {
                xMax = x;
            }
            
            if (yMax < y) {
                yMax = y;
            }
        }
        
        return xMax * yMax;
    }
}