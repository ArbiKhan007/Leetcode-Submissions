class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj=new ArrayList<> ();

        for(int i=0;i<n;i++) adj.add(new ArrayList<> ());

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double prob=succProb[i];

            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        PriorityQueue<Pair> q=new PriorityQueue<Pair> ((a,b)->Double.compare(b.prob,a.prob));
        q.add(new Pair(start_node, 1));
        double[] probs=new double[n];
        for(int i=0;i<n;i++) probs[i]=0;

        while(!q.isEmpty()){
            Pair p=q.poll();

            if(probs[p.v]>p.prob){
                continue;
            }

            //probs[p.v]=p.prob;
            for(Pair nbr:adj.get(p.v)){
                double newProb=p.prob*nbr.prob;
                if(newProb>probs[nbr.v]){
                    probs[nbr.v]=newProb;
                    q.add(new Pair(nbr.v, newProb));
                }
            }
        }

        return probs[end_node];
    }
}

class Pair{
    int v;
    double prob;

    Pair(int v, double prob){
        this.v=v;
        this.prob=prob;
    }
}