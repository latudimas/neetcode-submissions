class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        end = 0
        m_length = 0
        char_map = {}

        for end in range(len(s)):
            if s[end] in char_map and char_map[s[end]] >= start:
                start = char_map[s[end]] + 1

            char_map[s[end]] = end

            m_length = max(m_length, end - start + 1)

        return m_length