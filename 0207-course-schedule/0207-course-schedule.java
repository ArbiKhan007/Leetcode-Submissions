class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<> ();
        int[] indeg=new int[numCourses];
        int n=numCourses;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<> ());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            
            adj.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> q=new LinkedList<> ();
        int count=0;
        
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        };

        while(!q.isEmpty()){
            int p=q.poll();
            count++;
            for(int nbr:adj.get(p)){
                indeg[nbr]--;
                if(indeg[nbr]==0){
                    q.add(nbr);
                }
            }
        }

        if(count==n) return true;
        return false;
    }   
}