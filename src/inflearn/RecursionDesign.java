package inflearn;

public class RecursionDesign {
	public static void main(String[] args) {
		
		int []a = {5,9,123, 33, 12};
		System.out.println(search(a,0,a.length-1,5));
		
	}
	
	public static int search(int []data, int begin, int end, int target) {
		if(begin>end) return -1;
		else if (target == data[begin]) return begin;
		else return search(data, begin+1, end, target);
	}
}
