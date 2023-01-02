import sys
import math
N= int(sys.stdin.readline().rstrip())

num = list(str(math.factorial(N)))
cnt = 0
for i in range(len(num)-1,0,-1):
    if num[i] != '0':
        break
    cnt +=1

print(cnt)