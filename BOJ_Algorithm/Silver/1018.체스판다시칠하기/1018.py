import sys

n, m  = map(int,sys.stdin.readline().strip().split(' '))

column = []
board = []
res = []
for _ in range(n):
    board.append(list(sys.stdin.readline().rstrip()))

for i in range(n-7):
    for j in range(m-7):
        change1 = 0
        change2 = 0

        for col in range(i, i+8):
            for row in range(j, j+8):
                if (col+row) % 2 == 0 :
                    if board[col][row] != 'B':
                        change1 += 1
                    else :
                        change2 += 1
                else:
                    if board[col][row] != 'W':
                        change1 += 1
                    else :
                        change2 += 1
        res.append(change1)
        res.append(change2)

print(min(res))