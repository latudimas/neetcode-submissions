class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 ) {
            return nums;
        }
        
        int left = 0;
        List<Integer> maxList = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>(); // simpan posisi
        int maxNum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            // window.addLast(nums[right]);
            // maxNum = Math.max(maxNum, window.peekLast());
            
            while (!window.isEmpty() && nums[window.peekLast()] < nums[right]) {
                window.removeLast();
            }
            window.addLast(right);

            // Valid windows -> right-left + 1 == 3
            if ((right - left + 1) == k) {
                if (window.peekFirst() <= right - k) {
                    window.removeFirst();
                    
                }
                maxList.add(nums[window.peekFirst()]);
                left++;
            }

        }

        return maxList.stream().mapToInt(i -> i).toArray();
    }
}
