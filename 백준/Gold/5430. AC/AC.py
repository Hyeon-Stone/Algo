import sys
from collections import deque
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    p = deque(input().rstrip())
    n = int(input().rstrip())
    arr = deque(input().rstrip()[1:-1].split(","))
    rev = 0
    if p.count('D') > n:
        print('error')
        continue
    else:
        if n == 0:
            arr = deque()
        while p:
            func = p.popleft()
            if func == 'R':
                rev +=1
            elif func == 'D':
                if rev % 2 == 0:
                    arr.popleft()
                else:
                    arr.pop()
        if rev % 2 == 0:
            print("["+",".join(arr)+"]")
        else:
            arr.reverse()
            print("["+",".join(arr)+"]")