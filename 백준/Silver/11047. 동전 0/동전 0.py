import sys
input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
coinList = [int(input()) for _ in range(n)]
def coinCnt(coinList,n, k):
    if k == 0:
        return 0
    s = 0
    for i in range(n):
        if coinList[i] > k:
            s = i-1
    if s == 0:
        s = n-1
    cnt = 0
    while k != 0:
        if k >= coinList[s]:
            cnt += k // coinList[s]
            k %= coinList[s]
        else:
            s -= 1
    return cnt
print(coinCnt(coinList,n,k))