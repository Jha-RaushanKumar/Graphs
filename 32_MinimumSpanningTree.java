class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	   boolean vis[] = new boolean[V];
	    PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.second - b.second);
	    q.add(new Pair(0,0));
	    
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	    }
	       
	    int mst = 0;
	    while(!q.isEmpty()){
	        int node = q.peek().first;
	        int cost = q.peek().second;
	        q.remove();
	        if(vis[node]){
	            continue;
	        }
	        vis[node] = true;
	        mst += cost;
	        for(Pair it : adj.get(node)){
	            int neigh = it.first;
	            int ew = it.second;
	            if(!vis[neigh]){
	                q.add(new Pair(neigh,ew));
	            }
	        }
	    }
	    return mst;
	}
}
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}