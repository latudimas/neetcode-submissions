class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lProduct = new int[len];
        int[] rProduct = new int[len];
        int[] totalProduct = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                lProduct[i] = 1;
            } else {
                lProduct[i] = lProduct[i - 1] * nums[i - 1];
            }
        } 

        for (int j = len - 1; j >= 0; j--) {
            if (j == len -1) {
                rProduct[j] = 1;
            } else {
                rProduct[j] = rProduct[j + 1] * nums[j + 1]; 
            }
        }

        for (int k = 0; k < len; k++) {
            totalProduct[k] = lProduct[k] * rProduct[k];
        }

        return totalProduct;
    }
}  
