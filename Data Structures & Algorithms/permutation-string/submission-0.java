class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] validArr = new int[26];
        int[] windowArr = new int[26];
        int left = 0;
        int windowLen = s1.length();

        // checking
        if (windowLen > s2.length()) {
            return false;
        }

        // mapping the s1
        for (int i = 0; i < s1.length(); i++) {
            validArr[s1.charAt(i) - 'a'] += 1;
        }

        // window validation against s2
        for (int right = 0; right < s2.length(); right ++) {
            windowArr[s2.charAt(right) - 'a'] += 1;
            if ((right - left + 1) > windowLen) {
                windowArr[s2.charAt(left) - 'a'] -= 1;
                left++;
            }
            if (Arrays.equals(validArr, windowArr)) {
                return true;
            }
        }

        return false;
    }
}
