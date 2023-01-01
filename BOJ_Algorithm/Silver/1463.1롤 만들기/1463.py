import sys 
input = sys.stdin.readline
N = int(input().rstrip())
res = [0] * (N+1)

for i in range(2,N+1):
    res[i] = res[i-1] +1
    if i % 2 == 0: 
        res[i] = min(res[i], res[i//2] + 1)
    if i % 3 == 0: 
        res[i] = min(res[i], res[i//3] + 1)
    print(i, res)
print(res[N])

