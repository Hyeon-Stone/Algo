# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head) -> bool:
        if not head :
            return False
        nodeCnt = 0
        nodeCounter = head
        while(nodeCounter):
            nodeCnt += 1
            nodeCounter = nodeCounter.next
        
        node = head
        valList = []
        for i in range(nodeCnt//2):
            valList.append(node.val)
            node = node.next
        if (nodeCnt % 2 == 1):
            node = node.next

        while node:
            if(not valList or node.val != valList.pop()):
                return False
            node = node.next
        return True