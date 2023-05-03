class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        def solve(list1, list2):
            a = []
            for i in list1:
                if i not in list2:
                    a.append(i)
            return list(set(a))
        answer = []
        answer.append(solve(nums1, nums2))
        answer.append(solve(nums2, nums1))
        return answer