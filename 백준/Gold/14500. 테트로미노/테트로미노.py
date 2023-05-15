import sys
input = sys.stdin.readline
import math
n, m = map(int, input().split())
arr =[list(map(int, input().split())) for i in range(n)]
visited = [[False]*m for i in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
res = 0
maxSum = max(map(max,arr))
def dfs(r,c,cnt,sum):
    global res
    if res >= sum + (4-cnt)*maxSum:
        return
    if cnt == 4:
        res = max(res, sum)
        return
    for i in range(4):
        nx = r + dx[i]
        ny = c + dy[i]
        if 0<=nx<n and 0<=ny<m and visited[nx][ny] == False:
            if cnt == 2:
                visited[nx][ny] = True
                dfs(r,c,cnt+1,sum+arr[nx][ny])
                visited[nx][ny] = False
            visited[nx][ny] = True
            dfs(nx,ny,cnt+1,sum+arr[nx][ny])
            visited[nx][ny] = False
for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i,j,1,arr[i][j])
        visited[i][j] = False
print(res)