import sys
input = sys.stdin.readline
arr = [1, 1, 1]
T = int(input())
for _ in range(T) :
    n = int(input())
    if n > len(arr) :
        for i in range(len(arr), n) :
            arr.append(arr[i-2] + arr[i-3])
    print(arr[n-1])