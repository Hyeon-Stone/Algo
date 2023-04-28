class Solution:
    def romanToInt(self, s: str) -> int:
        symbolDict = {
            "I" : 1,
            "V" : 5,
            "X" : 10,
            "L" : 50,
            "C" : 100,
            "D" : 500,
            "M" : 1000
        }
        result = 0
        for i in range(len(s)-1):
            if symbolDict[s[i]] < symbolDict[s[i+1]]:
                result -= symbolDict[s[i]]
            else:
                result += symbolDict[s[i]]
        return result + symbolDict[s[-1]]