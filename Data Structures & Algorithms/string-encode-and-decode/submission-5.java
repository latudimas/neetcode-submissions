class Solution {
    String separator = "#";

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String s: strs) {
            sb.append(s.length()).append(separator).append(s);
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int separatorIndex = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, separatorIndex));
            int start = separatorIndex + 1;
            int end = start + len;

            String encodedStr = str.substring(start, end);
            decoded.add(encodedStr);

            i = end;
        }

        return decoded;
    }
}
