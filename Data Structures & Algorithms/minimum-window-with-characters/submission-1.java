class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> wMap = new HashMap<>();
        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        // fill tMap with value from t
        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = tMap.size();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            wMap.put(c, wMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && wMap.get(c).equals(tMap.get(c))) {
                have++;
            }

            while (have == need) {
                if ((right - left +1 ) < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char leftChar = s.charAt(left);
                wMap.put(leftChar, wMap.get(leftChar) -  1);
                if (tMap.containsKey(leftChar) && wMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                left++;
            }

        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, (bestStart + bestLen));
        
    }

}
 