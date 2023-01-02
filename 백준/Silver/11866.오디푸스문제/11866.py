import sys
n,k = map(int,sys.stdin.readline().split(' '))

num_list = [x for x in range(1,n+1)]
num = k-1
res = []
for i in range(len(num_list)):
    if num >= len(num_list):
        num = num%len(num_list)
        res.append(num_list.pop(num%len(num_list)))
        num += k-1
    else:
        res.append(num_list.pop(num))
        num += k-1

print("<", end="")
for i in range(n):
    if i == n-1:
        print(res[i], end="")
    else:
        print(res[i], end=", ")
print(">")
