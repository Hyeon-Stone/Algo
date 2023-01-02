import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,1,0,0]
dy = [0,0,1,-1]

def bfs(a,b):
    queue = deque([(a,b)])
    temp = 0
    while queue:
        x,y = queue.popleft()
        temp +=1
        for k in range(4):
            nx = x +dx[k]
            ny = y +dy[k]
            if nx > M-1 or ny > N-1 or nx < 0 or ny < 0:
                continue
            elif graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = 0
    if temp > 1:
        temp -= 1
    return temp

M, N, K = map(int,input().rstrip().split(' '))
graph = [[1]*N for _ in range(M)]
cnt = 0
res = []
for _ in range(K):
    x,y,x2,y2 = map(int,input().rstrip().split(' '))
    for i in range(y, y2):
        for j in range(x, x2):
            graph[i][j] = 0

for i in range(M):
    for j in range(N):
        if graph[i][j] == 1:
            res.append(bfs(i,j))
            cnt +=1
print(cnt)
res.sort()
for i in res:
    print(i, end = " ")