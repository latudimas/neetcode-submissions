class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // two pointer
        // 1 anchor (current or selcted number)
        // sorting the nums
        // looping starting from anchor
        //     if anchor
        //     set left: anchor + 1
        //     set right: nums.length - 1
        //
        //     jika sama, adjust val pointerA dan pointerB ke next index
        //     chech sum (if anchor + pointerA + pointerB == 0)
        //        put the numbers into list [anchor, pointerA, pointerB]
        //        sorting the numbers
        //        add into Set<List<Integer>>

        int[] sorted = nums.clone(); 
        Arrays.sort(sorted);

        int anchor = 0;
        int left = 0;
        int right = 0;

        List<List<Integer>> result = new ArrayList<>();

        // iterate for anchor
        for (int i = 0; i < sorted.length; i++) {
            anchor = i;
            left = anchor + 1;
            right = sorted.length - 1;

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
