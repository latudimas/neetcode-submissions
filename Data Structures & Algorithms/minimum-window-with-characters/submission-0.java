class Solution {
    public String minWindow(String s, String t) {
        int[] tArr = new int[128];
        int[] windowArr = new int[128];
        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (char c: t.toCharArray()) {
            tArr[c]++;
        }

        for (int right = 0; right < s.length(); right++) {
            windowArr[s.charAt(right)]++;

            while (isValid(windowArr, tArr)) {
                if((right - left + 1) < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                windowArr[s.charAt(left)]--;
                left++;
            }
        }

        if (bestLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestStart, (bestStart + bestLen));
        
    }

    private boolean isValid(int[] windowArr, int[] tArr) {
        for (int c = 0; c < 128; c++) {
            if (windowArr[c] < tArr[c]) {
                return false;
            }
        }
        return true;
    }
}
 