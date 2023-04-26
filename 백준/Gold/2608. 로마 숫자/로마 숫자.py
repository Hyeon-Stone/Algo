import sys
input = sys.stdin.readline

def romanToInt(s):
    symbolDict = { "I" : 1, "V" : 5, "X" : 10, "L" : 50, "C" : 100, "D" : 500, "M" : 1000 }
    res = 0
    for i in range(len(s)-1):
        if symbolDict[s[i]] < symbolDict[s[i+1]]:
            res -= symbolDict[s[i]]
        else:
            res += symbolDict[s[i]]
    return res + symbolDict[s[-1]]

def intToRoman(num):
    symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
    values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
    roman = ""
    for i, value in enumerate(values):
        while num >= value:
            num -= value
            roman += symbols[i]
    return roman

if __name__ == "__main__":
    values = [input().rstrip() for _ in range(2)]
    result = sum(romanToInt(value) for value in values)
    
    print(result)
    print(intToRoman(result))
