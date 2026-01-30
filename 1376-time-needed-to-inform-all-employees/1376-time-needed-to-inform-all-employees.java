class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> subord=new ArrayList<> ();

        for(int i=0;i<n;i++){
            subord.add(new ArrayList<> ());
        }

        for(int i=0;i<n;i++){
            int sub=i;
            int mng=manager[i];

            if(mng==-1) continue;

            subord.get(mng).add(sub);
        }

        Queue<Pair> q=new LinkedList<> ();
        q.add(new Pair(headID, 0));
        int tElapsed=0;

        while(!q.isEmpty()){
            Pair mngr=q.poll();
            int infTime=mngr.informTime;
            int manId=mngr.id;
            tElapsed=Math.max(tElapsed, infTime);

            for(int sub:subord.get(manId)){
                q.add(new Pair(sub, infTime+informTime[manId]));
            }
        }

        return tElapsed;
    }
}

class Pair{
    int id;
    int informTime;

    Pair(int id, int informTime){
        this.id=id;
        this.informTime=informTime;
    }
}