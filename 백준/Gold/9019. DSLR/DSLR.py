import sys
from collections import deque

input = sys.stdin.readline
N = int(input())

def D(x) :
    return (2 * x) % 10000

def S(x) :
    if x == 0 :
        return 9999
    else :
        return x-1

def L(x) :
    return x // 1000 + (x % 1000)*10

def R(x) :
    return (x // 10) + (x % 10)*1000

def dslr(i, x) :
    if i == 0 :
        return D(x)
    elif i == 1 :
        return S(x)
    elif i == 2 :
        return L(x)
    else :
        return R(x)

def bfs(A, B, visited) :
    queue = deque()
    queue.append(A)
    while queue :
        x = queue.popleft()
        res = visited[x]
        if x == B :
            return res
        for i in range(4) :
            asd = dslr(i, x)
            if visited[asd] == '' :
                queue.append(asd)
                visited[asd] = res + ['D', 'S', 'L', 'R'][i]
            

for _ in range(N) :
    visited = [''] * 10000
    A, B = map(int, input().split())
    print(bfs(A, B, visited))
