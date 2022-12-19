### 재귀 함수
def binarySearch(arr, x, low= None, high = None):
    low, high = low or 0 , high or (len(arr)-1)
    if low > high:
        return False 

    mid = (low + high) // 2 
    if x == arr[mid]:
        return mid
    elif x > arr[mid]:
        return binarySearch(arr, x, mid + 1, high)
    else:
        return binarySearch(arr, x, low, mid)
