class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for( String s : strs ){
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String s) {
      List<String> result = new ArrayList<>();
      int i=0;
      while(i < s.length()) {
        int j = s.indexOf("#", i);
        int len = Integer.parseInt(s.substring(i, j));
        String word = s.substring(j + 1, j + 1 + len);
        result.add(word);
        i = j + 1 + len;
      }

      return result;
    }
}
