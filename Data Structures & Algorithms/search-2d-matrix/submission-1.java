class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix[row][col]
        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;

        int l = 0;
        int r = lastRow;

        while(l <= r) {
            int m = l + (r-l) / 2;

            // criteria for we should check that row
            if((matrix[m][0] <= target) && (matrix[m][lastCol] >= target)) {
                // do binary search for that row
                int ll = 0;
                int rr = lastCol;

                while (ll <= rr){
                    int mm = ll + (rr - ll) / 2;
                    int[] row = matrix[m];

                    if (row[mm] == target) {
                        return true;
                    } else if (row[mm] < target) {
                        ll = mm + 1;
                    } else {
                        rr = mm - 1;
                    }
                }
                return false;

            } else if (matrix[m][0] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
