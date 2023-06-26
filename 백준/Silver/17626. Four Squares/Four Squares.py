import sys
import math
input = sys.stdin.readline
def make(square) :
    sqlen = len(square)
    temp = []
    for i in range(sqlen) :
        for j in range(i, sqlen) :
            temp.append(square[i]+square[j])
    return temp

def sol(n) :
    if n in square :
        return 1
    elif n in square2 :
        return 2
    else :
        for k in square :
            if n-k in square2 :
                return 3
    return 4
N = int(input())

square = [i*i for i in range(1, int(math.sqrt(N))+1)]
square2 = make(square)
print(sol(N))




