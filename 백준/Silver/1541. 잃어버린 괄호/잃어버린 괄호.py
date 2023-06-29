import sys
input = sys.stdin.readline


expression =input().rstrip().split('-')

answer = 0
if '+' in expression[0] :
    expression[0] = expression[0].split('+')
    for j in expression[0]:
        answer += int(j)
else:
    answer += int(expression[0])
for i in range(1, len(expression)):
    if '+' in expression[i]:
        expression[i] = expression[i].split('+')
        for j in expression[i]:
            answer -= int(j)
    else:
        answer -= int(expression[i])
print(answer)