package inflearn;

import java.util.Scanner;

public class Factorial {
	static int ans = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(fact(n));
	}
	
	public static int fact(int n) {
		if(n<=1) return n;
		else return(fact(n-1)*n);
	}
	
}
