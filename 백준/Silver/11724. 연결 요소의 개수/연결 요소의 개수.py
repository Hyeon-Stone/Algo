import sys
input = sys.stdin.readline
N,M = map(int,input().split())
UF = {}
def find(x):
    if x not in UF:
        UF[x] = x
    elif UF[x] != x:
        UF[x] = find(UF[x])
    return UF[x]
def union(x,y):
    x = find(x)
    y = find(y)
    UF[y] = x
for _ in range(M):
    a,b = map(int,input().split())
    union(a,b)
print(len(set(find(i) for i in range(1,N+1))))