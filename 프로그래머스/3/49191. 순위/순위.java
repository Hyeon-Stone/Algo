class Solution {

  public int solution(int n, int[][] results) {
    int[][] graph = new int[n][n];
    for(int[] result : results) {
      graph[result[0]-1][result[1]-1] = 1;
      graph[result[1]-1][result[0]-1] = -1;
    }


    for ( int k = 0; k < n; k++ ) {
      for ( int i = 0; i < n; i++ ) {
        for ( int j = 0; j < n; j++ ) {
          if(graph[i][k] == 1 && graph[k][j] == 1) {
            graph[i][j] = 1;
            graph[j][i] = -1;
          }
          if(graph[i][k] == -1 && graph[k][j] == -1) {
            graph[i][j] = -1;
            graph[j][i] = 1;
          }
        }
      }
    }
      
    int answer = 0;
    for(int v = 0; v < n; v++) {
      int count = 0;
      
      for(int w = 0; w < n; w++) {
        if(v == w) continue;
        if(graph[v][w] != 0) count++;
      }
      
      if(count == n - 1) answer++;
    }

    return answer;
  }
}