package pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_다익스트라 {
	static int V,E;
	static int d[];
	static int adj[][];
	static int t[];
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			d = new int[V+1];
			
			adj = new int[V+1][V+1];
			
			for(int i=0; i<=V; i++) {
				for(int j=0; j<=V; j++) {
					if(i==j) {
						adj[i][j] = 0;
					} else {
						adj[i][j] = INF;
					}
				}
			}
			
			for(int i=0; i<E; i++) {
				int n1, n2, w;
				st = new StringTokenizer(br.readLine());
				
				n1 = Integer.parseInt(st.nextToken());
				n2 = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				adj[n1][n2] = w;
			}
		}
	}
	
	public static void dij() {
		Dcomp cp = new Dcomp();
		PriorityQueue<Dnode> pq = new PriorityQueue<>(cp);
		
		for(int i=1; i<=V; i++) {
			d[i] = adj[0][i];
			if(adj[0][i] != 0 && adj[0][i] != INF) {
				pq.add(new Dnode(i,d[i]));
			}
		}
		
		while(!pq.isEmpty()) {
			Dnode tempNode = pq.poll();
			
			for(int i=0; i<=V; i++) {
				if(adj[tempNode.node][i] != 0 && adj[tempNode.node][i] != INF) {
					if(d[i] > d[tempNode.node] + adj[tempNode.node][i]) {
						d[i] = d[tempNode.node] + adj[tempNode.node][i];
						pq.add(new Dnode(i,d[i]));
					}
				}
			}
				
		}
		
	}
	
	
}

class Dnode {
	int node;
	int cost;
	public Dnode(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}

class Dcomp implements Comparator<Dnode>{

	@Override
	public int compare(Dnode o1, Dnode o2) {
		return o1.cost > o2.cost ? 1 : -1;
	}
	 
}

