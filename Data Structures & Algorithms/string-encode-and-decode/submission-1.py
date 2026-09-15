class Solution:

    def encode(self, strs: List[str]) -> str:
        join_str = len(strs)
        for curr_str in strs:
            join_str = str(join_str) + "##" + curr_str
        
        return join_str

    def decode(self, s: str) -> List[str]:
        split_len = s.split("##", 1)
        str_len = int(split_len[0])

        if (str_len == 0):
            return []

        decoded_str = s.split("##", str_len)
        decoded_str.pop(0)

        return decoded_str
