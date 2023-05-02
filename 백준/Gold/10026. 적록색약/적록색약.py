import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = [list(input().rstrip()) for _ in range(N)]
visited = [[0]*N for _ in range(N)]
answer = 0
answer2 = 0
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(a,b):
    visited[a][b] = 1
    queue = deque([(a,b)])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if graph[nx][ny] == graph[x][y] and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                queue.append((nx,ny))
    return

for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(i,j)
            answer += 1
for i in range(N):
    for j in range(N):
        if graph[i][j] == "G":
            graph[i][j] = "R"
visited = [[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(i,j)
            answer2 += 1
print(answer, answer2)