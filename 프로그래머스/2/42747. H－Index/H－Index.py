def solution(citations):
    maxH = max(citations)
    answer=0
    for h in range(0,maxH+1):
        check = 0
        for citation in citations:
            if (citation >= h):
                check += 1
        answer = max(answer,min(check, h))
    return answer