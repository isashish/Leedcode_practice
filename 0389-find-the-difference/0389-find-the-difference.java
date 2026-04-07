class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();

        // Count characters of s and put in mp
        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // Subtract using t
        for(char ch : t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            if(mp.get(ch) < 0){
                return ch;
            }
        }

        return 'x'; // This line will never execute
        
    }
}