package pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_위상정렬 {
	static int N,K;
	static int time[];
	static int W,n;
	static int in_degree[];
	static ArrayList<Node>[] arr;
	static int maxTime[];
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= ts; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			time = new int[N+1];
			in_degree = new int[N+1];
			arr = new ArrayList[N+1];
			q = new LinkedList();
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				arr[i] = new ArrayList();
			}
			
			
			for(int i=1; i<=K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int t = time[i];
				in_degree[to]++;
				arr[from].add(new Node(to,t));
			}
			 W = Integer.parseInt(br.readLine());
		}
	}
	
	public static void sort() {
		for(int i=1; i<=N; i++) {
			if(in_degree[i]==0) {
				q.add(i);
				maxTime[i] = time[i];
			}
		}
		
		while(!q.isEmpty() && in_degree[W] != 0) {
			int s = q.poll();
			
			for(int i=0; i<arr[s].size(); i++) {
				int e = arr[s].get(i).e;
				
				maxTime[e] = maxTime[s] + time[e] < maxTime[e] ? maxTime[e] : maxTime[s] + time[e];
				in_degree[e]--;
				
				if(in_degree[e] == 0) q.add(e);
				time[e] = maxTime[e];
			}
		}
	}
}




class Node {
	int e; int t;
	public Node(int e, int t) {
		super();
		this.e = e;
		this.t = t;
	}
	
	
}