import sys
input = sys.stdin.readline

S= list(input().rstrip())

S.sort(reverse=True)
print(''.join(S))