package inflearn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int a[];
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		 N = Integer.parseInt(br.readLine());
		 a = new int[N+1];
		 cnt = 0;
		 findQueen(0);
		
		
		bw.write(cnt + "");
		bw.flush();
	}
	
	public static void findQueen(int n) {
		if(N==n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			a[n] = i;
			if(checkQueen(n)) {
				findQueen(n+1);
			}
		}
		
	}
	
	public static boolean checkQueen(int n) {
		for(int i=0; i<n; i++) {
			if(a[i] == a[n]) return false;
			if((n-i) == (a[i]-a[n])) return false;
			if((n-i) == (a[n]-a[i])) return false;
		}		
		return true;
	}
	
	
}
