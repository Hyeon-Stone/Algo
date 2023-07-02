import sys

input = sys.stdin.readline

T = int(input())

def sol(M,N,x,y) :
    tempx = x
    while tempx <= M * N :
        if (tempx-x) % M == 0 and (tempx-y) % N == 0:
            return tempx            
        tempx += M
    return -1

for _ in range(T) :
    M, N, x, y = map(int, input().split())
    print(sol(M, N, x, y))
    