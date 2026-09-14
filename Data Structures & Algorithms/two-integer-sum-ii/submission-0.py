class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        pair_dict = {}

        for index, num in enumerate(numbers):
            pair_num = target - num
            if (pair_num in pair_dict):
                pair_index = pair_dict[pair_num]
                curr_index = index
                return [pair_index + 1, curr_index + 1]

            pair_dict[num] = index
    