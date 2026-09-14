class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        output_list = []

        for index in range(len(nums) - 1):
            i = index
            j = index + 1
            k = len(nums) - 1

            if i > 0 and nums[i] == nums[i-1]:
                continue

            while j < k:
                sum = nums[i] + nums[j] + nums[k]

                if sum > 0:
                    k -= 1
                elif sum < 0: 
                    j += 1
                elif sum == 0:
                    output_list.append([nums[i], nums[j], nums[k]])

                    # Skip duplicate values for j
                    while j < k and nums[j] == nums[j + 1]:
                        j += 1
                    
                    # Skip duplicate values for k
                    while j < k and nums[k] == nums[k - 1]:
                        k -= 1

                    j += 1
                    k -= 1

                    
        return output_list