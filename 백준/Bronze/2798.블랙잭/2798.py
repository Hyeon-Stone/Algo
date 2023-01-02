import sys
N, M = map(int,sys.stdin.readline().rstrip().split(' '))
card_list = list(map(int,sys.stdin.readline().split(' ')))

max_num = 0
for i in range(N):
    for j in range(i+1,N):
        for k in range(j+1,N):
            temp = card_list[i]+card_list[j]+card_list[k]
            if temp > max_num and temp <= M:
                max_num = temp
print(max_num)