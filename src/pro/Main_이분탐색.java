package pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이분탐색 {
	static int N;
	static int a[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <=ts; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			a = new int[N+1];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			
			int T = Integer.parseInt(br.readLine());
			int b[] = new int[T+10];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<T; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<T; i++) {
				System.out.println(binarySearch(b[i]));
			}
		}
	}
	
	public static int binarySearch(int n) {
		int s=0;
		int e=N;
		while(s<=e) {
			if(n>a[(s+e)/2]) {
				s = (s+e)/2+1;
			} else if(n<a[(s+e)/2]) {
				e = (s+e)/2-1;
			}
			if(n==a[(s+e)/2]) {
				return (s+e)/2;
			}
		}
		return 0;
	}
}
