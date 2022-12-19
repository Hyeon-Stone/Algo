import sys
n = int(sys.stdin.readline().rstrip())
num_list = [0] * 10001
for _ in range(n):
    num = int(sys.stdin.readline().rstrip())
    num_list[num] = num_list[num] + 1

for i in range(10001):
    if num_list[i] == 0:
        continue
    for j in range(num_list[i]):
        print(i)