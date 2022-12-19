import sys
from collections import Counter

def frequent(lst):
    freq_list = []
    counts = Counter(lst)
    for i in range(len(list(set(lst)))):
        if counts.most_common(1)[0][1] == counts.most_common()[i][1]:
            freq_list.append(counts.most_common(len(lst))[i][0])
        else:
            break
    return freq_list

n = int(sys.stdin.readline().strip())

data = []
for _ in range(n):
    data.append(int(sys.stdin.readline().strip()))

print(round(sum(data)/n))
data = sorted(data)

print(data[len(data)//2])


freq_list = frequent(data)
if (n == 1) or len(freq_list) == 1:
    print(freq_list[0])
else :
    print(sorted(freq_list)[1])

print(max(data) - min(data))