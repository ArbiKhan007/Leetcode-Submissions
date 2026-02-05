class Solution {
    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        int[] ans=new int[2];

        for(int i=0;i<n;i++){
            rank[i]=0;
            parent[i]=i;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            if(!union(u,v)){
                ans=edge;
                break;
            }
        }

        return ans;
    }

    public int findPar(int x){
        if(parent[x]!=x){
            return parent[x]=findPar(parent[x]);
        }

        return x;
    }

    public boolean union(int u, int v){
        int pu=findPar(u);
        int pv=findPar(v);

        if(pu==pv) return false;

        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }else if(rank[pv]<rank[pu]){
            parent[pu]=pv;
        }else{
            parent[pv]=pu;
            rank[pu]++;
        }

        return true;
    }
}