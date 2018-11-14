package pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_세그먼트트리 {
	static int N,M,k;
	static int num[];
	static long tree[];
	static long answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		num = new int[N+1];
		tree = new long[20000000];
		
		for(int i=1; i<=N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		//세그먼트 트리 생성
		make(1, 1, N);
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken()); 
		
		//x위치값과 y위치값 변경
		change(1, 1, N, x, num[y]-x);
		
		//left에서 right까지의 구간 합
		st = new StringTokenizer(br.readLine());
		
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		sum(1,1,N, left, right);
	}
	
	public static long make(int n, int s, int e) {
		if(s==e) {
			tree[n] = num[s];
			return tree[n];
		} else {
			long l = make(2*n, s, (s+e)/2);
			long r = make(2*n+1, (s+e)/2+1, e);
			tree[n] = l+r;
			return tree[n];
		}
	}
	
	public static void change(int n, int s, int e, int i, int diff) {
		if(s>i || e<i) return;
		else if(s==i && e==i) {
			tree[n] +=diff;
		}
		else if(s<=i && e>=i){
			tree[n] += diff;
			change(2*n, s, (s+e)/2, i, diff);
			change(2*n+1, (s+e)/2+1, e, i, diff);
		}
	}
	
	public static long sum(int n, int s, int e, int left, int right) {
		if(right<s || left>e) return 0;
		else if(s>=left && e<=right) {
			 return tree[n];
		} else {
			long l = sum(2*n, s, (s+e)/2, left, right);
			long r = sum(2*n+1, (s+e)/2+1, e, left, right);
			return l+r; 
		}
		
			
			
	}
	
}
