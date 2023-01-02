import sys

n = int(sys.stdin.readline().strip())
n_list = []
for _ in range(n):
    n_list.append(list(sys.stdin.readline().rstrip().split(' ')))

stack = []
for cmd in n_list:
    if cmd[0] == "push":
        stack.append(cmd[1])
    elif cmd[0] == "pop":
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif cmd[0] == "size":
        print(len(stack))
    elif cmd[0] == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif cmd[0] == "top":
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])