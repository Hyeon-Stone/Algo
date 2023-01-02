from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]
res = 0

def bfs(graph, n, m):
    while queue:
        x,y = queue.popleft()
        for i in range(len(dx)):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx>n-1 or ny>m-1 or nx<0 or ny<0 :
                continue
            elif graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])


if __name__ == "__main__":
    m, n = map(int,input().split())

    graph = []
    for i in range(n):
        graph.append(list(map(int,input().split())))   
    queue = deque([])
    for k in range(n):
        for j in range(m):
            if graph[k][j] == 1:
                queue.append((k,j))
    
    bfs(graph, n , m)
    for i in graph:
        for j in i:
            if j == 0:
                print(-1)
                exit(0)
        res = max(res, max(i))
    print(res - 1)
