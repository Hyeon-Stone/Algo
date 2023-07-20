import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = []
visited = [False] * N
def back() :
    if len(result) == M :
        print(*result)
        return
    temp = 0
    for i in range(N):
        if not visited[i] and temp != arr[i] :
            visited[i] = True
            result.append(arr[i])
            temp = arr[i]
            back()
            visited[i] = False
            result.pop()
back()