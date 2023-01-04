import sys
input = sys.stdin.readline

N = int(input().rstrip())
M = int(input().rstrip())
nobtn = []
if M != 0:
    nobtn = list(input().rstrip().split(' '))

sub = abs(100-N)
for i in range(1000000):
    flag = True
    for j in list(str(i)):
        if j in nobtn:
            flag = False
            break
    if flag:
        sub = min(abs(i-N) +len(str(i)),sub)
print(sub)