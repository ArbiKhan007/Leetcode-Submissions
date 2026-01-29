class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<> ();
        Queue<Integer> q=new LinkedList<> ();

        int n=numCourses;
        int[] res=new int[n];
        int idx=0;

        int[] indeg=new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<> ());
        }

        for(int[] row:prerequisites){
            int u=row[1];
            int v=row[0];

            indeg[v]++;
            adj.get(u).add(v);
        }

        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int p=q.poll();
            res[idx++]=p;

            for(int nbr:adj.get(p)){
                indeg[nbr]--;
                if(indeg[nbr]==0) q.add(nbr);
            }
        }

        if(idx!=n) return new int[] {};
        return res;
    }
}