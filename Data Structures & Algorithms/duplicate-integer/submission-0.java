class Solution {
    public boolean hasDuplicate(int[] all) {
        for(int i=0;i<all.length;i++){
            for(int j=i+1;j<all.length;j++) {
                if(all[i] == all[j]) {
                    return true ;
                }
            }
        }return false ;
    }
}