import sys
from collections import deque
input = sys.stdin.readline

def greedy():
    global meeting
    cnt = 1
    end = meeting[0][1]
    for i in range(1, N):
        if meeting[i][0] >= end:
            cnt += 1
            end = meeting[i][1]
    return cnt

meeting = []
N = int(input())
for _ in range(N):
    meeting.append(list(map(int, input().rstrip().split())))
meeting.sort(key=lambda x: (x[1],x[0]))

print(greedy())
