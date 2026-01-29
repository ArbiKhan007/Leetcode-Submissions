class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<> ();
        int n=numCourses;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<> ());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            
            adj.get(u).add(v);
        }

        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(hasCycle(adj, state, i)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean hasCycle(List<List<Integer>> adj, int[] state, int course){
        if(state[course]==1) return true;
        if(state[course]==2) return false;

        state[course]=1;

        for(int nbr:adj.get(course)){
            if(state[nbr]==1) return true;
            if(state[nbr]==0&&hasCycle(adj, state, nbr)){
                return true;
            }
        }

        state[course]=2;
        return false;
    }
}