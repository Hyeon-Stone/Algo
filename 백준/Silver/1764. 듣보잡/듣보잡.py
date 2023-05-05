import sys
input = sys.stdin.readline
N,M = map(int,input().split())
nameDict = {}
for _ in range(N):
    name = input().rstrip()
    nameDict[name] = 1
for _ in range(M):
    name = input().rstrip()
    if name in nameDict:
        nameDict[name] += 1
answer = []
for name in nameDict:
    if nameDict[name] >= 2:
        answer.append(name)

answer.sort()
print(len(answer))
for name in answer:
    print(name)