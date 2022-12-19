import sys
n = int(sys.stdin.readline().rstrip())
num_list = []
for _ in range(n):
    num_list.append(int(sys.stdin.readline().rstrip()))
num_list.sort()
for i in num_list:
    print(i)