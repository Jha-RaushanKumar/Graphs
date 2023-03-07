class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i< prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int indegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(ans.size() == numCourses){
            int[] arr = new int[numCourses];
            for(int it : ans){
                arr[i++] = it;
            }
            return arr;
        }
        int[] arr = new int[0];
        return arr;
    }
}