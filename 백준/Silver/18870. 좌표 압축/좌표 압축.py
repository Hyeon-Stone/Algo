import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int,input().rstrip().split()))
numsTemp = list(sorted(set(nums)))
numsDict = {numsTemp[i]:i for i in range(len(numsTemp))}

for i in range(N):
    print(numsDict[nums[i]],end=' ')