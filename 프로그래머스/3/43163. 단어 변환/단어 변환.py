from collections import deque
def solution(begin, target, words):
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])
    visited = set()
    
    while queue :
        current_word, steps = queue.popleft()
        if (current_word == target) :
            return steps
        
        for next_word in words:
            if next_word not in visited and checkChangeWord(current_word, next_word) :
                visited.add(next_word)
                queue.append((next_word, steps + 1))
    
    return 0

def checkChangeWord(begin, target) :
    sameChar = 0
    for idx in range(len(begin)) :
        if (begin[idx] != target[idx]) :
            sameChar += 1

    return sameChar == 1
    