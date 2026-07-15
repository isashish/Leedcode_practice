class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =new PriorityQueue<>(
            (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();   // frequency ascending
            }
            return b.getKey() - a.getKey();           // value descending
        });
        pq.addAll(map.entrySet());

        int[] ans = new int[nums.length];

        int indx = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
        
            int num = entry.getKey();
            int freq = entry.getValue();
            for(int i = 0; i < freq; i++){
                ans[indx] = num;
                indx++;
            }
        }
        
        return ans;
    }
}