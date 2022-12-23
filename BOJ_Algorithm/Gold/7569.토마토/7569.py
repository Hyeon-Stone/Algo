from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]
res = 0

def bfs(graph, n, m):
    while queue:
        x,y,z = queue.popleft()
        for i in range(len(dx)):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx>n-1 or ny>m-1 or nx<0 or ny<0 :
                continue
            elif graph[z][nx][ny] == 0:
                graph[z][nx][ny] = graph[z][x][y] + 1
                queue.append([nx, ny,z])
            if z-1 >= 0 :
                if graph[z-1][x][y] == 0:
                    graph[z-1][x][y] = graph[z][x][y] + 1
                    queue.append([x, y,z-1])
            if z+1 < h:
                if graph[z+1][x][y] == 0:
                    graph[z+1][x][y] = graph[z][x][y] + 1
                    queue.append([x, y,z+1])


if __name__ == "__main__":
    m, n, h = map(int,input().split())

    graph = []
    for p in range(h):
        temp = []
        for i in range(n):
            temp.append(list(map(int,input().split())))
        graph.append(temp)

    queue = deque([])
    for l in range(h):
        for k in range(n):
            for j in range(m):
                if graph[l][k][j] == 1:
                    queue.append((k,j,l))
    
    bfs(graph, n , m)
    for p in range(h):
        for i in graph[p]:
            for j in i:
                if j == 0:
                    print(-1)
                    exit(0)
            res = max(res, max(i))
    print(res - 1)
