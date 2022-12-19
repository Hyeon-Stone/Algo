import sys
word_list = []
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    word_list.append(sys.stdin.readline().rstrip())
word_list = list(set(word_list))

word_list = sorted(word_list, key = lambda x: (len(x),x))
for i in word_list:
    print(i)