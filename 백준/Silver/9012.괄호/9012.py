import sys
from collections import deque
string_list = []
n = int(sys.stdin.readline().strip())
for _ in range(n):
    string_list.append(list(sys.stdin.readline().rstrip()))

for s in string_list:
    stack = []
    flag = False
    for i in s:
        if i == '(':
            stack.append(i)
        elif i == ')':
            if len(stack) > 0 and stack[len(stack)-1] == '(':
                stack.pop()
            else:
                print("NO")
                flag = True
                break

    if  flag != True:
        if len(stack) == 0:
            print("YES")
        else:
            print("NO")