import sys
from collections import deque
input = sys.stdin.readline

dx= [-1, 1, 0, 0]
dy= [0, 0, -1, 1]

def bfs(a,b, k):
    queue = deque([(a,b)])
    visited[a][b] = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx > N-1 or ny > N-1 or nx < 0 or ny <0:
                continue
            elif graph[nx][ny] > k and visited[nx][ny] == 0:
                queue.append((nx,ny))
                visited[nx][ny] = 1

N = int(input().strip())
graph = []
cnt = 0
res = 0
for _ in range(N):
    graph.append(list(map(int,input().rstrip().split(' '))))

for i in range( 101):
    visited = [[0] * N for _ in range(N)]
    cnt = 0
    for x in range(N):
        for y in range(N):
            if graph[x][y] > i and visited[x][y] == 0:
                bfs(x,y, i)
                cnt += 1
    res = max(res,cnt)
print(res)