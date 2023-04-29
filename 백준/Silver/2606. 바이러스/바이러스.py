## 2606 바이러스
import sys
from collections import deque

input = sys.stdin.readline
UF = {}
def find(x):
    if UF[x] == x:
        return x
    UF[x] = find(UF[x])
    return UF[x]
def union(x, y):
    x = find(x)
    y = find(y)
    if x != y:
        UF[x] = y

computerLen = int(input())
computer = [i for i in range(1, computerLen+1)]
N = int(input())
for _ in range(N):
    a, b = map(int, input().split())
    if a not in UF:
        UF[a] = a
    if b not in UF:
        UF[b] = b
    union(a, b)
cnt = -1
for i in computer:
    if i in UF:
        if find(i) == find(1):
            cnt += 1
print(cnt)