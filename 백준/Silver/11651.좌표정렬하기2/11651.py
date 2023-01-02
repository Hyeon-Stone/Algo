import sys
n = int(sys.stdin.readline().rstrip())
num_list = []
for _ in range(n):
    num_list.append(list(map(int,sys.stdin.readline().split(' '))))

num_list = sorted(num_list, key = lambda x: (x[1],x[0]))

for i in num_list:
    for num in i:
        print(num, end = " ")
    print()