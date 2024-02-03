from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    graph = makeMap(rectangle)
    visited = [[False] * 102 for _ in range(102)]
    queue = deque([(characterX*2, characterY*2)])
    
    while queue:
        x,y = queue.popleft()
        visited[x][y] = True
        
        if x == itemX*2  and y == itemY*2:
            return graph[x][y] // 2
        
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if nx > 101 or ny > 101 or nx < 2 or ny < 2 :
                continue
            if visited[nx][ny] == False and graph[nx][ny] >= 1:
                queue.append([nx, ny])
                graph[nx][ny] = graph[x][y] + 1

def makeMap(rectangle) :
    graph = [[-1] * 102 for _ in range(102)] 
    for rec in rectangle:
        x1,x2 = rec[0] * 2, rec[2] * 2
        y1,y2 = rec[1] * 2, rec[3] * 2
        for x in range(x1, x2+1) :
            for y in range(y1, y2+1) :
                if (x1 < x < x2 and y1 < y < y2):
                    graph[x][y] = 0                
                elif graph[x][y] != 0:
                    graph[x][y] = 1                
    return graph

