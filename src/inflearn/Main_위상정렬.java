package inflearn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_위상정렬 {
	static int N,K;
	static int time[];
	static int W;
	static int n;
	static int in_degree[];
	static int maxTime[];
	static ArrayList<Node>[] arr;
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		time = new int[N+1];
		in_degree = new int[N+1];
		arr = new ArrayList[N+1];
		maxTime = new int[N+1];
		q = new LinkedList();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			time[i] = Integer.parseInt(st2.nextToken());
			arr[i] = new ArrayList<Node>();
		}
		
		for(int i=1; i<=K; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st3.nextToken());
			int to = Integer.parseInt(st3.nextToken());
			int t = Integer.parseInt(st3.nextToken());
			in_degree[to]++;
			arr[from].add(new Node(to,t));
		}
		W = Integer.parseInt(br.readLine());
				
		sort();
		System.out.println(maxTime[W]);
		
	}
	
	public static void sort() {
		for(int i=1; i<=N; i++) {
			if(in_degree[i] == 0 ) {
				q.add(i);
				maxTime[i] = time[i];
			}
		}
		
		while(!q.isEmpty() && in_degree[W] != 0) {
			int s = q.poll();
			
			for(int i=0; i<arr[s].size(); i++) {
				int e = arr[s].get(i).e;
				maxTime[e] = maxTime[s] + maxTime[e] < maxTime[e] ? maxTime[e] : (maxTime[s] + maxTime[e]);
				in_degree[e]--;
				
				if(in_degree[e]==0) {
					q.add(e);
					time[e] = maxTime[e];
				}
			}
		}
		
		
	}
	
}

class Node {
	int e; int t;
	public Node(int e, int t) {
		// TODO Auto-generated constructor stub
		this.e = e;
		this.t = t;
	}
}
