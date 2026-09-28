class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // One result per window. There are n - k + 1 windows of size k.
        int[] windowMaxes = new int[n - k + 1];

        // Monotonic deque of INDEXES (not values).
        // Invariant: nums[] at these indexes is decreasing from front to back,
        //   so the front is always the max of the current window.
        // Indexes are stored so we can tell when the front has left the window.
        Deque<Integer> candidates = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            // 1. Expire: drop the front if it has slid out of the window.
            //    The window covers [right - k + 1, right], so index <= right - k is outside.
            //    `if` is enough: the window moves one step, so at most one index leaves.
            if (!candidates.isEmpty() && candidates.peekFirst() <= right - k) {
                candidates.removeFirst();
            }

            // 2. Discard useless candidates from the back.
            //    Any smaller value that came BEFORE nums[right] can never be a max again:
            //    nums[right] is bigger and stays in the window at least as long.
            while (!candidates.isEmpty() && nums[candidates.peekLast()] < nums[right]) {
                candidates.removeLast();
            }

            // 3. Add the current index. It may become the max once bigger ones expire.
            candidates.addLast(right);

            // 4. Record: once the window is full (it has k elements), the front is its max.
            //    Window ending at `right` starts at right - k + 1, which is also its slot in the result.
            if (right >= k - 1) {
                windowMaxes[right - k + 1] = nums[candidates.peekFirst()];
            }
        }

        return windowMaxes;
    }
}