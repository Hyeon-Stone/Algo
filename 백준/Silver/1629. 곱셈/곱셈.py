import sys
input = sys.stdin.readline

A, B, C = map(int, input().split())


def sol(A,B,C) :
    if B == 1 :
        return A%C

    ans = sol(A, B//2, C)

    if B % 2 == 0 :
        return ans * ans % C
    
    else :
        return ans * ans * A % C

print(sol(A, B, C))
