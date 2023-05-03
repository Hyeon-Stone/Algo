import sys
import heapq
input = sys.stdin.readline

heap = []

N = int(input())
for _ in range(N):
    val = int(input())
    if val == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -val)
       
# 최대 힙
# import heapq
# heapq.heappush(heap, -value)
# -heapq.heappop(heap)

# 최소 힙
# import heapq
# heapq.heappush(heap, value)
# heapq.heappop(heap)

# 절대값 힙
# import heapq
# heapq.heappush(heap, (abs(value), value))
# heapq.heappop(heap)[1]
