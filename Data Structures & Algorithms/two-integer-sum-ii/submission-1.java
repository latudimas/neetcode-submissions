class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int cand = target - numbers[i];

            if (seen.containsKey(cand)) {
                return new int[] {seen.get(cand)+1, i+1 };
            }

            seen.put(numbers[i], i);
        }

        return new int[] {};
    }
}
