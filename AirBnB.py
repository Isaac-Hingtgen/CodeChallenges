# Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

# For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

# Follow-up: Can you do this in O(N) time and constant space?

numbers = [2,4,6,18,3,1,7,8,12,2,5]

class Node:
    def __init__(self, key) -> None:
        self.left = 0
        self.right = 0
        self.val = key
   

def getLargestPathRecursion(arr, cur, length):
    root = Node(0)
    if cur < length:
        root = Node(arr[cur])
        root.left = getLargestPathRecursion(arr, cur + 2, length)
        root.right = getLargestPathRecursion(arr, cur + 3, length)
    return max(root.left, root.right) + root.val

def getLargestPath(arr):
    return max(getLargestPathRecursion(arr, 0, len(arr)), getLargestPathRecursion(arr, 1, len(arr)))


print(getLargestPath(numbers))
