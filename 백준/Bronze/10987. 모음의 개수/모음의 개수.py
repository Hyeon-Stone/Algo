import sys
input = sys.stdin.readline
s = input().rstrip()
print(s.count("a") + s.count("e") + s.count("i") + s.count("o") + s.count("u"))