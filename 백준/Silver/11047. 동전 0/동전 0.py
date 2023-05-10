import sys
input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
coinList = [int(input()) for _ in range(n)]
def coinCnt(coinList,n, k):
    cnt = 0
    while k != 0:
        if k >= coinList[n]:
            cnt += k // coinList[n]
            k %= coinList[n]
        else:
            n -= 1
    return cnt
print(coinCnt(coinList,n-1,k))