import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = [list(map(int,input().split())) for _ in range(N)]

def dfs(N, graph):
    for i in range(N): # 거치는 점
        for j in range(N): # 시작하는 점
            for k in range(N): # 끝 점
                if graph[j][i] == 1 and graph[i][k] == 1:
                    graph[j][k] = 1
    return graph

res = dfs(N, graph)
for i in res :
    print(*i)
