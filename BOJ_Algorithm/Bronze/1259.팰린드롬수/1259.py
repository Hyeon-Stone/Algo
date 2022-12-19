import sys
n_list = []
while True:
    n = list(sys.stdin.readline().rstrip())
    if n == ["0"]:
        break
    n_list.append(n)

for i in n_list:
    low = 0
    high = len(i)-1
    flag= True
    while low <= high:
        if i[low] != i[high]:
            flag = False
            print("no")
            break
        low +=1
        high-=1

    if low == 0 and high == 0:
        print("no")
    elif flag == True:
        print("yes")