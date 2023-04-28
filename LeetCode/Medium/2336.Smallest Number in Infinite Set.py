# class SmallestInfiniteSet:

#     def __init__(self):
#         self.cur = 1
#         self.s = set()

#     def popSmallest(self) -> int:
#         if self.s:
#             res = min(self.s)
#             self.s.remove(res)
#             return res
#         else:
#             self.cur +=1
#             return self.cur - 1
        

#     def addBack(self, num: int) -> None:
#         if self.cur > num:
#             self.s.add(num)
        
class SmallestInfiniteSet:

    def __init__(self):
        self.s = set(i for i in range(1,1001))

    def popSmallest(self) -> int:
        res = min(self.s)
        self.s.remove(res)
        return res
        

    def addBack(self, num: int) -> None:
        self.s.add(num)
        


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)