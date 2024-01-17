from collections import deque
def solution(priorities, location):
    answer = 0
    queue = deque([(i, p) for i, p in enumerate(priorities)])
    cnt = 0
    while True :
        process = queue.popleft()
        maximum = False
        
        for _, p in queue:
            if p > process[1] :
                queue.append(process)
                maximum = True
                break
        if not maximum:
            if process[0] == location:
                return answer+1
            answer+=1
    return answer