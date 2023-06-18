import sys
from collections import deque 
input = sys.stdin.readline
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

N, M = map(int, input().split())
mapp = [list(map(int, input().split())) for _ in range(N)]
arr = [[-1] * M for _ in range(N)]

def dfs(i, j) :
    q = deque([(i,j)])
    while q :
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < N and 0 <= ny < M :
                if mapp[nx][ny] == 1 and arr[nx][ny] == -1:
                    arr[nx][ny] = arr[x][y] + 1
                    q.append([nx,ny])
    

for i in range(N) :
    for j in range(M) :
        if mapp[i][j] == 2 :
            arr[i][j] = 0
            dfs(i,j)
        elif mapp[i][j] == 0 :
            arr[i][j] = 0

for i in range(N) :
    for j in range(M) :
        print(arr[i][j], end = ' ')
    print()