class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        result = 0
        for i in range(len(s)-k+1):
            subs = s[i:i+k]
            maximum = subs.count("a") + subs.count("e") + subs.count("i") + subs.count("o") + subs.count("u")
            if maximum > result :
                result = maximum
        return result