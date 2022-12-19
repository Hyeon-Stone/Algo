import sys
n = int(sys.stdin.readline().rstrip())
user_list = []
for i in range(n):
    user_list.append(list(map(int,sys.stdin.readline().rstrip().split(' '))))
for i in range(n):
    cnt = 1
    for j in range(n):
        if  (user_list[i][0] < user_list[j][0]) and (user_list[i][1] < user_list[j][1]):
            cnt +=1
    print(cnt ,end=" ")