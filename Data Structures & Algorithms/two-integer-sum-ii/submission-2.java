class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int left = i;
        int right = numbers.length - 1;

        while (i < numbers.length - 1) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left+1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
            i++;
        }

        return new int[] {};
    }
}
