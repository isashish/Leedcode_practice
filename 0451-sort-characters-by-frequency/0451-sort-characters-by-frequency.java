class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                map.put(c, freq + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder ans = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();

            char ch = entry.getKey();
            int freq = entry.getValue();
            for(int i = 0; i < freq; i++){
                ans.append(ch);
            }
        }
        
        return ans.toString();

    }
}