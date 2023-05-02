import sys
input = sys.stdin.readline

N = int(input())
sequence = list(map(int, input().split()))
dp = [[0]*N for _ in range(N)]
M = int(input())

for i in range(N):
    dp[i][i] = 1
for i in range(N-1):
    if sequence[i] == sequence[i+1]:
        dp[i][i+1] = 1
for i in range(2, N):
    for j in range(N-i):
        if sequence[j] == sequence[j+i] and dp[j+1][j+i-1]:
            dp[j][j+i] = 1

for _ in range(M):
    a, b = map(int, input().split())
    print(dp[a-1][b-1])