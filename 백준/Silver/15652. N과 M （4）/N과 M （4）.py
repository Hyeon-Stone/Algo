import sys
input = sys.stdin.readline

N, M = map(int, input().split())
result = []
def back() :
    if len(result) == M :
        print(' '.join(map(str, result)))
        return
    for i in range(1, N+1) :
        if len(result) != 0 :
            if i < result[-1] :
                continue
            result.append(i)
            back()
            result.pop()
        else :
            result.append(i)
            back()
            result.pop()
back()