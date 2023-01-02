import sys
from collections import deque
n = int(sys.stdin.readline().strip())

card = deque([x for x in range(1,n+1)])
while len(card) > 1:
    card.popleft()
    card.append(card.popleft())
print(card[0])