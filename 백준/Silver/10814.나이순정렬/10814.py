import sys
n = int(sys.stdin.readline().rstrip())
user_list = []
for i in range(n):
    user = list(sys.stdin.readline().rstrip().split(' '))
    user_list.append(user)

for user in user_list:
    print(user[0], user[1])