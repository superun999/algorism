package pro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_퀵소트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int data[] = {66,10,1,34,5,-10};
		
		sort(data, 0, data.length-1);
		for(int i=0; i<data.length-1; i++) {
			System.out.println("data[" +i+"] : " + data[i]);
		}
		
		
		
	}
	
	public static void sort(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l+r)/2];
		
		while(left<=right) {
			while(data[left] < pivot) left++;
			while(data[right] > pivot) right--;
			
			if(left<=right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}
		
		if(l<right) sort(data, l, right);
		if(r>left) sort(data,left,r);
	}
}
