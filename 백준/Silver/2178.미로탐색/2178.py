import sys
from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]
def bfs():
    queue= deque([(0,0)])
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x +dx[i]
            ny = y +dy[i]
            if nx>N-1 or ny>M-1 or nx<0 or ny<0 :
                continue
            elif miro[nx][ny] == 1:
                miro[nx][ny] = miro[x][y] + 1
                queue.append((nx, ny))

    return miro[N-1][M-1]

N, M = map(int, sys.stdin.readline().rstrip().split(' '))
miro =[]
for _ in range(N):
    miro.append(list(map(int,sys.stdin.readline().rstrip())))
print(bfs())