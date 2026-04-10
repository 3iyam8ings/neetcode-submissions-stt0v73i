

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> respawn = new HashMap<>();
        for( int num : nums) {
            respawn.put(num, respawn.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(respawn.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int [] result = new int[k];
        for(int i = 0; i<k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
