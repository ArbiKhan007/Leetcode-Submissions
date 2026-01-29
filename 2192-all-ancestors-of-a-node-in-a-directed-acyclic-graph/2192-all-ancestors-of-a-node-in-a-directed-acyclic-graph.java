class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<> ();
        List<Set<Integer>> anc=new ArrayList<> ();
        List<List<Integer>> res=new ArrayList<> ();
        int[] indeg=new int[n];

        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<> ());
        }

        for(int i=0;i<n;i++){
            anc.add(new TreeSet<> ());
        }

        for(int i=0;i<edges.length;i++){
            int[] row=edges[i];
            int u=row[0];
            int v=row[1];
            indeg[v]++;
            adj.get(u).add(v);
        }

        Queue<Integer> q=new LinkedList<> ();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int p=q.poll();

            for(int nbr:adj.get(p)){
                anc.get(nbr).add(p);
                anc.get(nbr).addAll(anc.get(p));

                indeg[nbr]--;
                if(indeg[nbr]==0) q.add(nbr);
            }
        }

        for(int i=0;i<n;i++){
            res.add(new ArrayList<> (anc.get(i)));
        }

        return res;
    }
}