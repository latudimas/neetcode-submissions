class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        
        Set<Integer> setNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        List<Integer> sortedSet = setNums.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedSet);

        int maxCounter = 0;
        int counter = 0;
        int prevVal = 0;
        for(int i = 0; i < sortedSet.size(); i++) {
            if (i == 0) {
                counter++;
                prevVal = sortedSet.get(i);
                //System.out.println("[i == %d]Counter: %d    prevVal: %d".formatted(i, counter, prevVal));
                continue;
            }

            int currVal = sortedSet.get(i); 
            if (currVal - prevVal == 1) {
                counter++;
                maxCounter = Math.max(maxCounter, counter);
                prevVal = sortedSet.get(i);
                //System.out.println("[i == %d] Counter: %d    prevVal: %d".formatted(i, counter, prevVal));
            } 

            if (currVal - prevVal > 1) {
                counter = 0;
                prevVal = sortedSet.get(i);
            }
        }

        return maxCounter;
    }
}
