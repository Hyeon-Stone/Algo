import sys
from collections import deque
input = sys.stdin.readline
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(a,b):
    queue = deque([(a,b)])
    graph[a][b] = 0
    cnt = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx > N-1 or ny > N-1 or nx < 0 or ny < 0:
                continue
            elif graph[nx][ny] == 1:
                graph[nx][ny] = 0
                cnt +=1
                queue.append((nx,ny))
    return cnt

N = int(input().rstrip())
graph = []
res = []
for _ in range(N):
    graph.append(list(map(int, input().rstrip())))

for w in range(N):
    for l in range(N):
        if graph[w][l] == 1:
            res.append(bfs(w,l))
            
print(len(res))
res.sort()
for i in res:
    print(i)