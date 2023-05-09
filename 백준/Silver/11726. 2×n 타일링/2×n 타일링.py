import sys
input = sys.stdin.readline

n = int(input())
def method(n):
    a = 2
    b = 3
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 3
    else:
        i = 3
        while i != n:
            a,b = b, (a+b)%10007
            i+=1
        return b

print(method(n))