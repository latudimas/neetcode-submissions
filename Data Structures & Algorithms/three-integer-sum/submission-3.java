class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int[] sorted = nums.clone(); 
        Arrays.sort(sorted);

        List<List<Integer>> result = new ArrayList<>();

        // iterate for anchor
        for (int i = 0; i < sorted.length; i++) {
            int anchor = i;
            int left = anchor + 1;
            int right = sorted.length - 1;

            if (anchor > 0 && sorted[anchor] == sorted[anchor - 1]) {
                continue;
            }

            while (left < right) {
                int sum = sorted[anchor] + sorted[left] + sorted[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(List.of(sorted[anchor], sorted[left], sorted[right]));

                    left++;
                    right--;

                    while (left < right && sorted[left] == sorted[left - 1]) {
                        left++;
                    }

                    while (left < right && sorted[right] == sorted[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
