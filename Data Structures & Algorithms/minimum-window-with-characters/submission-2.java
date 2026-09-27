class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> tMap = new HashMap<>();  // required count per char in t
        Map<Character, Integer> wMap = new HashMap<>();  // count per char in current window
        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;  // sentinel: no valid window found yet

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // have: number of t's distinct chars that currently have enough copies in the window
        // need: number of distinct chars in t
        // window is valid when have == need (O(1) check instead of comparing every char)
        int have = 0;
        int need = tMap.size();

        for (int right = 0; right < s.length(); right++) {
            // grow: add the char entering on the right
            char c = s.charAt(right);
            wMap.put(c, wMap.getOrDefault(c, 0) + 1);

            // c just reached its required count: count it as satisfied (once).
            // Use == not >=, so extra copies don't increase have again.
            if (tMap.containsKey(c) && wMap.get(c).equals(tMap.get(c))) {
                have++;
            }

            // shrink: while valid, try to make the window smaller
            while (have == need) {
                // record the window before shrinking, since it may become invalid
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                // remove the char leaving on the left
                char leftChar = s.charAt(left);
                wMap.put(leftChar, wMap.get(leftChar) - 1);

                // leftChar just dropped below its required count: no longer satisfied
                if (tMap.containsKey(leftChar) && wMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
 