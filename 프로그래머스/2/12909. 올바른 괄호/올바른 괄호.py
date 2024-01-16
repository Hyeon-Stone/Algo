def solution(s):
    stack = []
    for bracket in s :
        if len(stack) == 0 or (stack[-1] + bracket != "()") :
            stack.append(bracket)
            continue
        stack.pop()
    
    if len(stack) == 0:
        return True
    return False