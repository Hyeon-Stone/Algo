from collections import deque
import sys

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(graph, x, y):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx>N-1 or ny>M-1 or nx<0 or ny<0 :
                continue
            elif graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))


if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip()) 
    for i in range(T):
        cnt = 0
        N, M, K = map(int, sys.stdin.readline().rstrip().split(' '))
        graph = [[0]* M  for _ in range(N)]
        for _ in range(K):
            X, Y = map(int, sys.stdin.readline().rstrip().split(' '))
            graph[X][Y] = 1
        
        for x in range(N):
            for y in range(M):
                if graph[x][y] == 1:
                    bfs(graph,x,y)
                    cnt+=1
        print(cnt)
