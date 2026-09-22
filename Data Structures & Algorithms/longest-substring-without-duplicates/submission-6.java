class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();
        int maxSub = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            // System.out.println("LEFTidx: %d || RIGHTidx: %d  --- val: %c".formatted(left, right, s.charAt(right)));
            char current = s.charAt(right);

            if(charSet.contains(current)) {
                int subLen = charSet.size();
                maxSub = Math.max(maxSub, subLen);
                charSet.clear();
                left++;
                right = left;
            } else {
                charSet.add(current);
                right++;
            }
            
            // System.out.println("SET -> " + charSet);
        }

        if (!charSet.isEmpty()) {
            maxSub = Math.max(maxSub, charSet.size());
        }
        return maxSub;
    }
}
