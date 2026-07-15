class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> { 
                if(!a.getValue().equals(b.getValue())){ 
                    return b.getValue() - a.getValue(); 
                } 
                return a.getKey().compareTo(b.getKey()); 
            }
        );
        pq.addAll(map.entrySet());

        List<String> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            Map.Entry<String, Integer> entry = pq.poll();
            list.add(entry.getKey());
        }

        return list;
    }
}