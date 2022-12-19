import sys


n = int(sys.stdin.readline().strip())
n_list = list(map(int,sys.stdin.readline().split(' ')))
m = int(sys.stdin.readline().strip())
m_list = list(map(int,sys.stdin.readline().split(' ')))

hash = {}

for i in n_list:
    if i in hash:
        hash[i] += 1
    else:
        hash[i] = 1

for i in m_list:
    if i in hash:
        print(hash[i], end=' ')
    else:
        print(0, end=' ')