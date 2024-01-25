from collections import deque

def solution(n, computers):
    answer = 0
    visited = [False] * n
    for hop in range(n) :
        if visited[hop] == False :
            BFS(n, computers, hop, visited)
           # DFS(n, computers, hop, visited)
            answer += 1
    return answer

def DFS(n, computers, hop, visited):
    visited[hop] = True 
    for i in range(n): 
        if i != hop and computers[i][hop] == 1 and visited[i] == False:    
                DFS(n, computers, i, visited)

def BFS(n, computers, hop, visited):
    queue = deque()
    queue.append(hop)
    while queue:
        hop = queue.pop()
        visited[hop] = True
        for i in range(n) :
            if i != hop and computers[i][hop] == 1 and visited[i] == False:   
                queue.append(i)