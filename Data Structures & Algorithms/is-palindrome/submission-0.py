class Solution:
    def isPalindrome(self, s: str) -> bool:
        arr = []

        for char in s:
            if char.isalnum():
                arr.append(char.lower())

        # ceiling division
        middle = -(-len(arr)//2)

        if len(arr) % 2 != 0:
            left = arr[:middle - 1]
            right = arr[middle:]
            left.reverse()
            return left == right
        else:
            left = arr[:middle]
            right = arr[middle:]
            left.reverse()
            return left == right
        