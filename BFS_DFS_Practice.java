import java.util.*;
class Main {
	static class Edge{
		int data;
		int src;
		int dest;
		public Edge(int src,int dest){
			this.src=src;
			this.dest=dest;
		}
	}
	public static void graphCreat(ArrayList<Edge> graph[]){
     for(int i=0;i<graph.length;i++){
		 graph[i]=new ArrayList<Edge>();
	 }
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(6, 5));

	}
public static void BFS(ArrayList<Edge> graph[],int V){
	boolean vis[]=new boolean[V];
	Queue<Integer> q=new ArrayDeque<>();
	q.add(0);
	while(!q.isEmpty()){
		int cur=q.remove();
		while(!vis[cur]){
		System.out.print(cur+" ");
		vis[cur]=true;
		for(int i=0;i<graph[cur].size();i++){
			Edge e=graph[cur].get(i);
			q.add(e.dest);
		   }
		}
	}
}
	
	public static void DFS(ArrayList<Edge> graph[],int cur,boolean vis[]){
		System.out.print(cur+" ");
		vis[cur]=true;
		for(int i=0;i<graph[cur].size();i++){
			Edge e=graph[cur].get(i);
			if(!vis[e.dest]){
				DFS(graph, e.dest, vis);
			}
		}
		
	}
  public static void main(String[] args) {
	  int V=7;
    ArrayList<Edge> graph[]=new ArrayList[V];
	  boolean vis[]=new boolean[V];
	  graphCreat(graph);
	  // BFS(graph,V);
	  DFS(graph, 0, vis);
	  
  }
}
