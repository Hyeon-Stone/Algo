import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

N = int(input())
time = list(map(int, input().split()))
time.sort()
total = 0
for i in range(N):
    total += sum(time[:i+1])
print(total)