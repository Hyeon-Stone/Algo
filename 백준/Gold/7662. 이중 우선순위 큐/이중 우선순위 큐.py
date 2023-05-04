import heapq
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    q = []
    maxq = []
    N = int(input())
    visited = [False] * N
    for i in range(N):
        DI, num = input().rstrip().split()
        if DI == "I":
            heapq.heappush(q, (int(num), i))
            heapq.heappush(maxq, (-int(num), i))
            visited[i] = True
        else:
            if num ==  "1":
                while maxq and not visited[maxq[0][1]]:
                    heapq.heappop(maxq)
                if maxq:
                    visited[maxq[0][1]] = False
                    heapq.heappop(maxq)
            else:
                while q and not visited[q[0][1]]:
                    heapq.heappop(q)
                if q:
                    visited[q[0][1]] = False
                    heapq.heappop(q)

    if True not in visited:
        print("EMPTY")
    else:
        while maxq and not visited[maxq[0][1]]:
            heapq.heappop(maxq)
        while q and not visited[q[0][1]]:
            heapq.heappop(q)
        print(-heapq.heappop(maxq)[0], heapq.heappop(q)[0])