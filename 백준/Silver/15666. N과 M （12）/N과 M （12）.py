import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(set(map(int, input().split())))
arr.sort()
result = []
def back() :
    if len(result) == M :
        print(*result)
        return
    for i in arr:
        if len(result) != 0:
            if i < result[-1] :
                continue
        result.append(i)
        back()
        result.pop()
back()