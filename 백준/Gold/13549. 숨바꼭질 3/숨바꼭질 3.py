## 13549 숨바꼭질 3
import sys
from collections import deque
input = sys.stdin.readline

def dfs(v):
    queue = deque([v])
    while queue:
        r = queue.popleft()
        if r == K:
            return graph[r]
        for i in (r*2, r-1, r+1):
            if 0 > i or i > 100000:
                continue
            if graph[i] == 0:
                if i == r*2:
                    graph[i] = graph[r]
                else:
                    graph[i] = graph[r] +1
                queue.append(i)

N, K = map(int,input().rstrip().split(' '))
graph = [0 for _ in range(100001)]
print(dfs(N))