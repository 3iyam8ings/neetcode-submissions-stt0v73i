//1. use two pointrs left and right 
//2. use frequency array/map
//3. track MaxFreq to store most frequent char in window 
//4. expand windoe from right 
//5. if invalid -> shrink from left 
//6. update maxlenght 

class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        int maxlen = 0;
        int left=0;
        int maxfreq = 0;
        for(int right=0 ; right< s.length(); right++) {
            //increase frequency pf curret character
            freq[s.charAt(right) - 'A']++;
            //update maxfreq
            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);
        
        //if window invalid
        while((right - left +1) - maxfreq > k) {
            freq[s.charAt(left) - 'A']--;
            left++;
        }

        maxlen = Math.max(maxlen, right - left + 1);
    }
    return maxlen ;
}
}
