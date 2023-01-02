import sys
from collections import deque
input = sys.stdin.readline

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [1, -1, 2, -2, 2, -2, -1, 1]


def dfs(x,y):
    queue = deque([(x,y)])

    while queue:
        x,y = queue.popleft()
        if x == mov_x and y == mov_y:
            return  graph[x][y]-1
        for i in range(8):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx > l-1 or ny > l-1 or nx <0 or ny < 0:
                continue
            elif graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] +1
                queue.append((nx,ny))

T = int(input().rstrip())
for _ in range(T):
    l = int(input().rstrip())
    now_x, now_y = map(int, input().split(' '))
    mov_x, mov_y = map(int, input().split(' '))
    graph = [[0]*l for _ in range(l)]
    graph[now_x][now_y] = 1
    print(dfs(now_x,now_y))