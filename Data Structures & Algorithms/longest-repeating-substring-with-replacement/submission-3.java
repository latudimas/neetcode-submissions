class Solution {
    //Question : 
    // For this current substring, how many characters would I need to replace 
    // so that the whole substring becomes one repeating character?

    public int characterReplacement(String s, int k) {
        int left = 0;
        Map <Character, Integer> freq = new HashMap<>(); //frequency each character on the current window
        int maxFreq = 0; // most common letter in current windows
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(right)));

            // rumus windows valid: (window size) - (most common letter) <=k
            // estimate the character should be changed
            // maksudnya, dari windows size sekian, yang perlu diganti itu sebanyak <= k
            // lebih, berarti windownsya tidak valid
            while((right - left + 1) - maxFreq > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }
            
            maxLength = Math.max(maxLength, (right - left + 1));
        }

        return maxLength;
    }
}
