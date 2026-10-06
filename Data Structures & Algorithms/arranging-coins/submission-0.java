class Solution {
    public int arrangeCoins(int n) {
        int remaining = n; 
        for (int i = 1; i <= n; i++){
            remaining = remaining - i;

            if (remaining == 0){
                return i;
            } else if (remaining < 0) {
                return i - 1;
            } 
            
        } 
        return n;
    }
}