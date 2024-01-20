def solution(array, commands):
    answer = []
    for command in commands:
        # for i in range(command[0]-1, command[1]) :
            
        arr = sorted(array[command[0]-1:command[1]])
        answer.append(arr[command[2]-1])
    return answer