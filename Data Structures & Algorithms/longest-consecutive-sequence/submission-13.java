class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> setNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int maxLength = 0;

        for (Integer val : setNums) {
            if (setNums.contains(val - 1)) {
                continue;
            }

            int currVal = val;
            int currLen = 1;
            while(setNums.contains(currVal + 1)) {
                currVal++;
                currLen++;
            }

            maxLength = Math.max(currLen, maxLength);
        }

        return maxLength;
    }
}
