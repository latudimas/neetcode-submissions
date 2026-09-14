class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxs = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        } 

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9 ; x++) {
                
                // check current value
                char currVal = board[y][x];
                if (currVal == '.'){
                    continue;
                }

                // determine coordinate for box
                int corY = y/3;
                int corX = x/3;
                int boxIndex = (corY * 3) + corX;

                // check value for each cell
                if(!rows[y].add(currVal)) {
                    return false;
                }

                if(!cols[x].add(currVal)) {
                    return false;
                }

                if(!boxs[boxIndex].add(currVal)) {
                    return false;
                }
            }
        }
        return true;
    }
}
