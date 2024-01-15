def solution(progresses, speeds):
    answer = []
    days = []
    for i in range(len(progresses)) :
        day = (100 - progresses[i]) // speeds[i]
        if (((100 - progresses[i]) % speeds[i]) != 0) :
            day += 1
        
        if (len(days) == 0 or max(days) >= day):
            days.append(day)
        else :
            answer.append(len(days))
            days = [day]
    if (len(days) != 0) :
        answer.append(len(days))
    return answer