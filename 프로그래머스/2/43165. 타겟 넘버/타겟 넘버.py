def solution(numbers, target):
    queue = [0]
    for num in numbers:
        temp = []
        while queue:
            cal = queue.pop()
            temp.append(cal+num)
            temp.append(cal-num)
        queue = temp
    return queue.count(target)