import sys
from collections import deque
def solve(m, priorty):
    cnt = 0
    queue = deque(priorty)
    while len(queue) > 0 :
        temp = queue.popleft()
        m -= 1
        if temp == max(priorty):
            cnt += 1
            priorty.remove(temp)
            if m == -1:
                print(cnt)
                break
        else:
            queue.append(temp)
            if m == -1:
                m = len(queue) - 1

test_cnt = int(sys.stdin.readline().strip())

m_list= []
que_list = []
for _ in range(test_cnt):
    n, m = map(int,sys.stdin.readline().split(' '))
    m_list.append(m)
    priorty = list(map(int,sys.stdin.readline().split(' ')))
    que_list.append(priorty)

for i in range(test_cnt):
    solve(m_list[i],que_list[i])