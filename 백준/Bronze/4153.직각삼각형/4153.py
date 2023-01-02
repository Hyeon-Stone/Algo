import sys
line_list = []
while True:
    line = list(map(int,sys.stdin.readline().split(' ')))
    if line == [0,0,0]:
        break
    line_list.append(line)

for line in line_list:
    line.sort()
    if line[0] ** 2 + line[1]**2 == line[2]**2:
        print("right")
    else:
        print("wrong")