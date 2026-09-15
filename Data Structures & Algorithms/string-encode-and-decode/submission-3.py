class Solution:

    def encode(self, strs: List[str]) -> str:
        if (len(strs) == 0):
            return ""

        join_str = len(strs)
        for curr_str in strs:
            join_str = str(join_str) + "##" + curr_str
        
        return join_str

    def decode(self, s: str) -> List[str]:
        if len(s) == 0:
            return []

        split_len = s.split("##", 1)
        str_len = int(split_len[0])

        decoded_str = s.split("##", str_len)
        decoded_str.pop(0)

        return decoded_str
