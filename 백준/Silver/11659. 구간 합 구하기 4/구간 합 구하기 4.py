import sys

input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))

sumList = [0] * (N+1)
for i in range(N) :
    sumList[i+1] = sumList[i] + numbers[i]
for i in range(M) :
    a, b = map(int, input().split())
    print(sumList[b] - sumList[a-1])
