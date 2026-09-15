class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums.sort()
        seq_set = set()
        for i, val in enumerate(nums):

            if (val - nums[i-1]) > 1:
                print("Break")
                print(f"{val} --- {i}")
                break
            print(f"Outside: {val} --- {i}")
            seq_set.add(val)
        

        return len(seq_set)