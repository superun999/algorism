package inflearn;

public class Code01 {
	public static void main(String[] args) {
		
		System.out.println(func(4));
		System.out.println(fibo(9));
		System.out.println(gcd(20,6));
				
		
	}
	
	public static int func(int n) {
		if(n==0) return 0;
		
		else {
			return n+func(n-1);
		}
	}
	//피보나치
	public static int fibo(int n) {
		if(n<2) return n;			
		else return fibo(n-1) + fibo(n-2);
	}
	
	//최대공약수
	public static int gcd(int m, int n) {
		/*if(m<n) {
			int temp=m; m=n; n=temp;
		}
		if(m%n==0) return n;*/
		
		if(n==0) return m;		
		else return gcd(n, m%n);
	}
}
