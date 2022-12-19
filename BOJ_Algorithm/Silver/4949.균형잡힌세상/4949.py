import sys
from collections import deque
string_list = []
while True:
    string = sys.stdin.readline().rstrip()
    if string == ".":
        break
    string_list.append(list(string))

for s in string_list:
    stack = []
    flag = False
    for i in s:
        if i == '(' or i == '[':
            stack.append(i)
        elif i == ')':
            if len(stack) > 0 and stack[len(stack)-1] == '(':
                stack.pop()
            else:
                print("no")
                flag = True
                break
        elif i == ']':
            if len(stack) > 0 and  stack[len(stack)-1] == '[':
                stack.pop()
            else:
                print("no")
                flag = True
                break

    if  flag != True:
        if len(stack) == 0:
            print("yes")
        else:
            print("no")