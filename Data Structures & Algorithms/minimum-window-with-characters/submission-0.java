class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "" ;
        }
        Map < Character, Integer> countT = new HashMap<>() ;
        for(char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c,0)+1);
        }
        int required = countT.size();

        Map<Character, Integer> windowCounts = new HashMap<>();
        int left =0 , right = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right< s.length()) {
            char c = s.charAt(right);
        windowCounts.put(c,windowCounts.getOrDefault(c,0)+1);
        if(countT.containsKey(c) && windowCounts.get(c).intValue() == countT.get(c).intValue()) {
            formed++;
        }
        while(left<=right && formed == required) {
            if(right - left +1 < minLen) {
                minLen = right - left +1 ;
                start = left ;
            }
            char leftChar = s.charAt(left);
            windowCounts.put(leftChar,windowCounts.get(leftChar) - 1);
            if(countT.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < countT.get(leftChar).intValue()) {
                formed --;
            } left++;
        } right++;
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
