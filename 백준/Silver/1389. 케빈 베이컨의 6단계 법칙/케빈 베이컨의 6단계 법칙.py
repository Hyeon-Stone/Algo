import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [[] for _ in range(n+1)]
result = []
for i in range(m):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)

def bfs(arr, start):
    num = [0] * (n+1)
    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue :
        x = queue.popleft()
        for i in arr[x] :
            if not visited[i] :
                num[i] = num[x] + 1
                queue.append(i)
                visited[i] = True
    return sum(num)

for i in range(1,n+1):
    visited = [False for _ in range(n+1)]
    result.append(bfs(arr,i))

print(result.index(min(result))+1)