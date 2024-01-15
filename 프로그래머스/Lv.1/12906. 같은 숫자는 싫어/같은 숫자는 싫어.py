def solution(arr):
    answer = []
    temp = []
    for value in arr:
        if (len(temp) == 0) :
            temp.append(value)
        else :
            if (temp[-1] != value) :
                answer.append(temp[-1])
                temp.clear()
                temp.append(value)
    if(len(temp) != 0) :
        answer.append(temp[-1])
    return answer