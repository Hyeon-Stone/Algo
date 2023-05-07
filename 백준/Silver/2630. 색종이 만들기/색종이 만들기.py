import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
def dividePaper(x,y,n):
    global blue
    global white
    global papaer
    global N

    if N == 1:
        if papaer[x][y] == 1:
            blue += 1
        else:
            white += 1
        return
    else:
        color = papaer[x][y]
        for i in range(x, x+n):
            for j in range(y, y+n):
                if papaer[i][j] != color:
                    dividePaper(x, y, n//2)
                    dividePaper(x+n//2, y, n//2)
                    dividePaper(x, y+n//2, n//2)
                    dividePaper(x+n//2, y+n//2, n//2)
                    return
        if color == 1:
            blue += 1
        else:
            white += 1
        return

N = int(input())
papaer = []
blue = 0
white = 0
for _ in range(N):
    papaer.append(list(map(int, input().split())))
dividePaper(0, 0, N)
print(white)
print(blue)