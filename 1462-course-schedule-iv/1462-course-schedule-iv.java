class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();

        boolean[] vis = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        // isPrerequisite[a][b] = true
        // means a is a prerequisite of b
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        for(int[] course : prerequisites){
            int preC = course[0];
            int c = course[1];
            adj.get(preC).add(c);

            isPrerequisite[preC][c] = true;
        }

        int[] inDegree = new int[numCourses];

        for(int i = 0; i < adj.size(); i++){
            for(int node : adj.get(i)){
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        //Kahn's Algorithm
        int i  = 0;
        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int next : adj.get(current)){

                // Every prerequisite of current
                // is also a prerequisite of next
                for (int pre = 0; pre < numCourses; pre++) {

                    if (isPrerequisite[pre][current]) {
                        isPrerequisite[pre][next] = true;
                    }
                }

                inDegree[next]--;

                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        for(int[] query : queries){
            int preCourse = query[0];
            int course = query[1];

            ans.add(isPrerequisite[preCourse][course]);
        } 
        return ans;
    }
}