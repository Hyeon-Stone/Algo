import sys
input = sys.stdin.readline
revsymbolDict = {
    1: "I",
    5: "V",
    10: "X",
    50: "L",
    100: "C",
    500: "D",
    1000: "M"
}

def romanToInt(s):
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

valueList = []
valueList.append(input().rstrip())
valueList.append(input().rstrip())

res = 0
for value in valueList:   
    res += romanToInt(value)
print(res)


mulCal = 1
roman =""
while res :
    tempNum = res%10
    res //= 10
    if tempNum == 4:
        roman = revsymbolDict[5*mulCal] + roman
        roman = revsymbolDict[1*mulCal] + roman
    elif tempNum == 9:
        roman = revsymbolDict[10*mulCal] + roman
        roman = revsymbolDict[1*mulCal] + roman
    else:
        if tempNum >= 5:
            while tempNum != 5:
                roman = revsymbolDict[1*mulCal] + roman
                tempNum -= 1
            roman = revsymbolDict[5*mulCal] + roman
            tempNum -= 5

        else:
            while tempNum:
                roman = revsymbolDict[1*mulCal] + roman
                tempNum -= 1
    mulCal *= 10
print(roman)