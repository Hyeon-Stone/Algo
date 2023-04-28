# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        rootNode = head
        nodeCnt = 0
        while(rootNode):
            nodeCnt += 1
            rootNode = rootNode.next
        for i in range(nodeCnt//2):
            head = head.next
        return head