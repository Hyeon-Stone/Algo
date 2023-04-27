def isPalindrome(s):
    sLength = len(s)
    if sLength % 2 == 1 :
        left = sLength//2-1
        right = sLength//2+1
    else:
        left = sLength//2-1
        right = sLength//2
    while left >= 0 and right < len(s):
        if s[left] != s[right]:
            return 0
        left -= 1
        right += 1
    return 1    

import sys
input = sys.stdin.readline
string = input().rstrip()
print(isPalindrome(string))