import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
def distance(a, b, c):
    return sum(int(a[i]!=b[i]) + int(b[i]!=c[i]) + int(c[i]!=a[i]) for i in range(4))
for _ in range(T) :
    N = int(input())
    mbti = list(map(str, input().split()))
    res = []
    if N > 32 :
        print(0)
        continue
    else :
        for i in range(N-2) :
            for j in range(i+1, N-1):
                for k in range(j+1, N) :
                    res.append(distance(mbti[i], mbti[j], mbti[k]))
    print(min(res))
