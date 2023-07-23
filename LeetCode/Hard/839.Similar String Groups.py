# Union Find
UF = {}
def find(val):
    if val not in UF:
        UF[val] = val
    elif UF[val] != val:
        UF[val] = find(UF[val])
    return UF[val]

def union(val1, val2):
    rootX = find(val1)
    rootY = find(val2)
    UF[rootX] = rootY

def is_similar(val1, val2):
    if val1 == val2:
        return True
    diff = 0
    for i in range(len(val1)):
        if val1[i] != val2[i]:
            diff +=1
    return diff == 2
class Solution:
    def numSimilarGroups(self, strs) -> int:
        for i in range(len(strs)):
            for j in range(i+1, len(strs)):
                if is_similar(strs[i], strs[j]):
                    union(strs[i], strs[j])
        return len(set(find(val) for val in strs))        
# 2자리만 다른지 Check
# But 여러개의 List에서 모두 2자리만 다른 문자열이 있다면?
# 그럼 List를 이어 붙여줘야 함
