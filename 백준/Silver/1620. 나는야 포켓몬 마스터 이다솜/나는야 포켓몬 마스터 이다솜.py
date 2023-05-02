import sys
input = sys.stdin.readline
N, M = map(int, input().split())
haspmap = {}
haspmap2 = {}
for i in range(N):
    name = input().rstrip()
    haspmap[i] = name
    haspmap2[name] = int(i)+1
for _ in range(M):
    poketmon = input().rstrip()
    if poketmon.isdigit():
        print(haspmap[int(poketmon)-1])
    else:
        print(haspmap2[poketmon])