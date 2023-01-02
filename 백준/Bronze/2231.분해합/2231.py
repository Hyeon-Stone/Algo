import sys
N = int(sys.stdin.readline().rstrip())
flag = True
for i in range(N):
    temp_list = list(str(i))
    sum_ = 0
    for j in temp_list:
        sum_ += int(j)
    temp = i + sum_
    if temp == N:
        print(i)
        flag = False
        break
if flag:
    print(0)