class Solution {

    static int calcProduct(int[] input) {
        return Arrays.stream(input).reduce(1, (a,b) -> a * b);
    }
    
    public int[] productExceptSelf(int[] nums) {

        List<Integer> resList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int leftSide = 0;
            int rightSide = 0;

            if (i == 0) {
                rightSide = calcProduct( Arrays.copyOfRange(nums, i+ 1, nums.length));
                resList.add(rightSide);
            } else if (i == nums.length -1) {
                leftSide = calcProduct(Arrays.copyOfRange(nums, 0, i));
                resList.add(leftSide);
            } else {
                leftSide = calcProduct(Arrays.copyOfRange(nums, 0, i));
                rightSide = calcProduct(Arrays.copyOfRange(nums, i+ 1, nums.length));
                resList.add(leftSide * rightSide);
            }
        }

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}  
