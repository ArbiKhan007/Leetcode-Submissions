class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<> ();

        for(int i=0;i<n;i++) adj.add(new ArrayList<> ());

        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int cost=flights[i][2];

            adj.get(u).add(new Pair(v, cost));
        }

        Queue<Dest> q=new LinkedList<> ();
        q.add(new Dest(src, 0, 0));

        int[] cst=new int[n];
        Arrays.fill(cst, Integer.MAX_VALUE);
        cst[src]=0;

        while(!q.isEmpty()){
            Dest d=q.poll();
            int node=d.v;
            int cost=d.cost;
            int stops=d.stops;

            if(stops>k){
                continue;
            }
            for(Pair nbr:adj.get(node)){
                if(nbr.cost+cost<cst[nbr.v]&&stops<=k){
                    cst[nbr.v]=nbr.cost+cost;
                    q.add(new Dest(nbr.v,cost+nbr.cost,stops+1));
                }
            }
        }

        if(cst[dst]==Integer.MAX_VALUE) return -1;
        return cst[dst];
    }
}

 class Dest{
    int v,cost,stops;

    Dest(int v, int cost, int stops){
        this.v=v;
        this.cost=cost;
        this.stops=stops;
    }
}

class Pair{
    int v,cost;

    Pair(int v, int cost){
        this.v=v;
        this.cost=cost;
    }
}
