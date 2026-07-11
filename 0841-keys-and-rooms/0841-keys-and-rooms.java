class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        bfs(0, rooms, visited);
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
    private void bfs(int room, List<List<Integer>> rooms, boolean[] vis){
        vis[room] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(room);

        while(!q.isEmpty()){
            int key = q.remove();
            vis[key] = true;
            for(int k : rooms.get(key)){
                if(vis[k] != true && !q.contains(k)){
                    q.add(k);
                }
            }
        }
    }
}