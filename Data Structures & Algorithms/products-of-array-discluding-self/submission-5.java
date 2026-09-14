class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lProduct = new int[len];
        int[] rProduct = new int[len];
        int[] totalProduct = new int[len];

        lProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            lProduct[i] = lProduct[i - 1] * nums[i - 1];
        }

        rProduct[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            rProduct[j] = rProduct[j + 1] * nums[j + 1];
        }

        for (int k = 0; k < len; k++) {
            totalProduct[k] = lProduct[k] * rProduct[k];
        }

        return totalProduct;
    }
}
