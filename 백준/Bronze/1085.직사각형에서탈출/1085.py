import sys
x,y,w,h = map(int,sys.stdin.readline().split(' '))
temp = [x, y, w-x, h-y]

print(min(temp))