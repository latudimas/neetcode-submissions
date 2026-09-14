class Solution:
    def isValid(self, s: str) -> bool:
        bracket = {
            '}' : '{',
            ']' : '[',
            ')' : '('
        }

        stack = []
        for char in s:
            if char not in bracket:
                stack.append(char)
            else:
                if not stack or stack.pop() != bracket[char]:
                    return False

        return len(stack) == 0