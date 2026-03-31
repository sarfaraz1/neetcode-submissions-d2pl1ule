class Solution {

 public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0, j, length = 0;
        List<String> strs = new ArrayList<>();
        while (i < str.length()) {
            j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            length = Integer.parseInt(str.substring(i, j));
            j++;
            strs.add(str.substring(j, j + length));
            i = j + length;
        }
        return strs;
    }
}
