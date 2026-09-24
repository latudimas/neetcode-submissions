class Solution {
    //Question : 
    // For this current substring, how many characters would I need to replace 
    // so that the whole substring becomes one repeating character?

    public int characterReplacement(String s, int k) {
        int left = 0;
        Map <Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(right)));

            while((right - left + 1) - maxFreq > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, (right - left + 1));
        }

        return maxLength;
    }
}
