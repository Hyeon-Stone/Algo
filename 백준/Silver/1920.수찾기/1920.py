import sys

def binarySearch(arr, x, low, high):
    while low <= high:
        mid = (low + high) // 2
        if x == arr[mid]:
            print(1)
            return
        elif x < arr[mid]:
            high = mid -1
        else:
            low = mid + 1
    print(0)

n = int(sys.stdin.readline().strip())
A_set = list(map(int,sys.stdin.readline().split(' ')))
A_set.sort()
m = int(sys.stdin.readline().strip())
M_set = list(map(int,sys.stdin.readline().split(' ')))

for i in M_set:
    binarySearch(A_set, i, 0, len(A_set)-1)