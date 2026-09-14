class MinStack:

    def __init__(self):
        self.my_list = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.my_list.append(val)

        if len(self.min_stack) != 0:
            min_val = min(self.min_stack[-1], val)
            self.min_stack.append(min_val)
        else:
            self.min_stack.append(val)

    def pop(self) -> None:
        self.my_list.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.my_list[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]