import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
arr =[]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
cnt = 0
visited = [[False] * M for _ in range(N)]
for _ in range(N) :
    arr.append(list(input()))


def dfs(i, j) :
    global cnt
    queue = deque([(i, j)])
    while queue :
        x, y = queue.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M :
                if arr[nx][ny] != 'X' and not visited[nx][ny] :
                    visited[nx][ny] = True
                    if arr[nx][ny] == 'P' :
                        cnt += 1
                    queue.append((nx, ny))


for i in range(N) :
    for j in range(M) :
        if (arr[i][j] == 'I') :
            dfs(i, j)

if cnt == 0 :
    print("TT")
else :
    print(cnt)
