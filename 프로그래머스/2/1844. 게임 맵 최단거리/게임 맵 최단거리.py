from collections import deque
def solution(maps):
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    n = len(maps)
    m = len(maps[0])
    queue = deque([[0,0]])
    
    while queue:
        x, y = queue.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if nx > n-1 or ny > m-1 or nx < 0 or ny < 0 :
                continue
            if (maps[nx][ny] == 1 ) :
                maps[nx][ny] = maps[x][y] + 1
                
                queue.append([nx,ny])
    
    answer = maps[n-1][m-1]
    if (answer == 1) :
        return -1
    return answer
