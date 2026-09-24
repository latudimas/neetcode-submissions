class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> count = new HashMap<>();
            int freq = 0;
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                freq = Math.max(freq, count.get(s.charAt(j)));
                if((j - i + 1) - freq <= k) {
                    maxFreq = Math.max(maxFreq, j - i + 1);
                } 
            }
        }

        return maxFreq;
    }
}
