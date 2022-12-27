from collections import deque
import sys

def dfs(k):
    visited = [k]
    queue = deque()
    queue.append(k)
    while queue:
        v = queue.popleft()
        print(v, end=" ")

        for i in range(len(graph[k])):
            if graph[v][i] == 1 and (i not in visited):
                queue.append(i)
                visited.append(i)    

def bfs(v, visited = []):
    visited.append(v)
    print(v, end=" ")

    for i in range(len(graph[v])):
        if graph[v][i] == 1 and (i not in visited):
            bfs(i, visited)

if __name__ == '__main__':
    N, M, K = map(int, sys.stdin.readline().rstrip().split(' '))
    graph = [[0]*(N+1) for _ in range(N+1)]
    for _ in range(M):
        X, Y = map(int, sys.stdin.readline().rstrip().split(' '))
        graph[X][Y] = graph[Y][X] = 1
    bfs(K)
    print()
    dfs(K)
