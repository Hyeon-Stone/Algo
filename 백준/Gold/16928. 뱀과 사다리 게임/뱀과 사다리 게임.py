import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

snake = {}
ladder = {}
for i in range(n):
    a, b = map(int, input().split())
    snake[a-1] = b-1
for i in range(m):
    a, b = map(int, input().split())
    ladder[a-1] = b-1
board = [0] * 100
def snakeAndLadder(a):
    q = deque([a])
    while(board[99] == 0):
        a = q.popleft()
        for i in range(1,7):
            nextP = a+i
            if a+i < 100 and board[a+i] == 0:
                if a+i in snake:
                    nextP = snake[a+i]
                elif a+i in ladder:
                    nextP = ladder[a+i]
                if board[nextP] == 0:
                    board[nextP] = board[a] + 1
                    q.append(nextP)
        
snakeAndLadder(0)
print(board[99])