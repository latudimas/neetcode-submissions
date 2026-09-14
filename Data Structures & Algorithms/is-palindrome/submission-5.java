class Solution {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] sChar = s.toLowerCase().toCharArray();
        if (sChar.length == 0) {
            return true;
        }
        int half = sChar.length/2;
        int counter = 0;
        int lIndex = 0;
        int rIndex = sChar.length - 1;
        System.out.println("Output" + Arrays.toString(sChar));


        while(counter <= half) {
            if (sChar[lIndex] == sChar[rIndex]) {
                System.out.println("lIndex: %d -> %c   ||   rIndex: %d -> %c".formatted(lIndex, sChar[lIndex], rIndex, sChar[rIndex]));
                lIndex++;
                rIndex--;
                counter++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
