class Solution:
    def addDigits(self, num: int) -> int:
        while num > 9 :
            res = 0
            while num:
                res += num%10
                num //= 10
            num = res
        return num