import sys
input = sys.stdin.readline

S = set()
N = int(input())
for _ in range(N):
    temp = input().split()
    
    if len(temp) == 1:
        if temp[0] == "all":
            S = set([i for i in range(1, 21)])
        else:
            S = set()
    else:
        operation, i = temp[0], temp[1]
        i = int(i)
        if operation == "add":
            S.add(i)
        elif operation == "remove":
            S.discard(i)
        elif operation == "check":
            if i in S:
                print(1)
            else:
                print(0)
        elif operation == "toggle":
            if int(i) in S:
                S.discard(i)
            else:
                S.add(i)