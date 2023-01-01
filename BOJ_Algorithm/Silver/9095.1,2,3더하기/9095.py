import sys
input = sys.stdin.readline

T = int(input())
dp = [1,2,4]
for i in range(T):
    N = int(input())
    while len(dp) < N:
        dp.append(dp[len(dp)-1] + dp[len(dp)-2] + dp[len(dp)-3])
    print(dp[N-1])