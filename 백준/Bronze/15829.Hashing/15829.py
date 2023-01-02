import sys
L= int(sys.stdin.readline().rstrip())
card_list = list(sys.stdin.readline().rstrip())

r = 31
M = 1234567891
num = 0

for idx, i in enumerate(card_list):
    num += int(ord(i)-0x60) * r**idx

print(num % M)