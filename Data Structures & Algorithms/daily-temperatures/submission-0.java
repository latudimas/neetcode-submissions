class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // if i > i-1
        //      put into stack
        //      start counter
        //      save into map key: temp[i] val = index
        // if i < i-1
        //      pop the top
        //      search the key in map, update the value with index
        //      replace the top with current value
        //      serch the
        //
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (currTemp < temperatures[j]) {
                    output[i]  = j - i;
                    break;
                } 
            }
        }
        return output;
    }
}
