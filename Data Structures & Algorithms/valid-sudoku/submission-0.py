class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_dict = [set() for _ in range(9)]
        col_dict = [set() for _ in range(9)]
        box_dict = [set() for _ in range(9)]

        for i, row in enumerate(board):
            for j, cell in enumerate(row):
                
                if cell == ".":
                    continue

                box_index = (i // 3) * 3 + (j // 3)

                if cell in row_dict[i] or cell in col_dict[j] or cell in box_dict[box_index]:
                    return False
                
                row_dict[i].add(cell)
                col_dict[j].add(cell)
                box_dict[box_index].add(cell)

        return True