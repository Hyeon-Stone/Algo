import sys
input = sys.stdin.readline

p = "IOI"
n = int(input())
m = int(input())
s = input().rstrip()

p = "IOI" + "OI" * (n - 1)
cnt = 0
for i in range(m-len(p)+1):
    if s[i] == "I":
        if s[i:i+len(p)] == p:
            cnt += 1
print(cnt)