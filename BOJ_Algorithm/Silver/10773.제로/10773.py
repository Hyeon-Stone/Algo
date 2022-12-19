import sys
from collections import deque
num_list = []
n = int(sys.stdin.readline().strip())
for _ in range(n):
    num_list.append(int(sys.stdin.readline().strip()))
stack = []
for i in num_list:
    if i == 0 :
        stack.pop()
    else:
        stack.append(i)
print(sum(stack))