class MinStack:

    def __init__(self):
        self.my_list = []


    def push(self, val: int) -> None:
        self.my_list.append(val)

    def pop(self) -> None:
        pop_val = self.my_list.pop()

    def top(self) -> int:
        return self.my_list[-1]

    def getMin(self) -> int:
        return min(self.my_list)