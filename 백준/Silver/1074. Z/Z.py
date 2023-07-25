# 수학
import sys
input = sys.stdin.readline

def Z(N,r,c):
    if N == 0 :
        return 0
    else:
        return 2 * (r%2) + (c%2) + 4 * Z(N-1, r//2, c//2)

N,r,c= map(int,input().split(' '))
print(Z(N,r,c))
