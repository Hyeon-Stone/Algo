class Solution:
    def lastStoneWeight(self, stones) -> int:
        while(len(stones) > 1):
            stones.sort(reverse = True)
            print(stones)
            if stones[0] == stones[1]:
                stones.pop(1)
                stones.pop(0)
            else:
                stones[0] -= stones[1]
                stones.pop(1)
        if len(stones) == 0:
            return 0
        else:
            return stones[0]

