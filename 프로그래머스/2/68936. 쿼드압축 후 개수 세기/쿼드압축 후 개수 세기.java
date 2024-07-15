class Solution {
    private static int zeroCount = 0;
    private static int oneCount = 0;
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return new int[] {zeroCount, oneCount};
    }
    
    private static void dfs(int[][] arr, int x, int y, int size) {
        // 내부 값이 모두 같을 경우 종료
        boolean lastFlag = true;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (arr[y][x] != arr[j][i]) {
                    lastFlag = false;
                    dfs(arr, x, y, size/2);
                    dfs(arr, x+size/2, y, size/2);
                    dfs(arr, x, y+size/2, size/2);
                    dfs(arr, x+size/2, y+size/2, size/2);
                    break;
                }
            }   
            
            if (lastFlag == false) {
                break;
            }
        }
        
        if (lastFlag == true) {
            if (arr[y][x] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }
    }
}