def binarySearch(lines, m, low, high):
    if low > high:
        return high
    mid = (low + high) // 2 
    cnt = 0
    for line in lines:
        if line >= mid:
            cnt += line//mid
    if cnt >= m:
        return binarySearch(lines, m, mid + 1, high)
    else:
        return binarySearch(lines, m, low, mid-1 )

import sys
k, n = map(int, sys.stdin.readline().split(' '))
lines = [int(sys.stdin.readline().strip()) for _ in range(k)]
start, end = 1, sum(lines)
print(binarySearch(lines,n,start,end))