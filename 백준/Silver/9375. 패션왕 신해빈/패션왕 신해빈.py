import sys
input = sys.stdin.readline


T = int(input())
for _ in range(T) :
    clothes = {}
    N = int(input())
    for _ in range(N) :
        name, kind = input().split()
        if kind in clothes :
            clothes[kind].append(name)
        else :
            clothes[kind] = [name]
    cnt = 1

    for k in clothes:
        cnt *= (len(clothes[k])+1)
    print(cnt-1)
