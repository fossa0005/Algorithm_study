package d2;

import java.util.Arrays;
import java.util.Scanner;

public class No1959_두개의숫자열 {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int[] longer;
		int[] shorter;
		//test
		//N M
		//N길이
		//M길이
		
		
		
		int test = sc.nextInt();
		for(int t=1; t<=test; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(N<M) {
				longer = new int[M];
				shorter = new int[N];
				
				for(int i=0; i<N; i++) {
					shorter[i] = sc.nextInt();
				}
				
				for(int i=0; i<M; i++) {
					longer[i] = sc.nextInt();
				}
				
			} else {
				longer = new int[N];
				shorter = new int[M];
				
				for(int i=0; i<N; i++) {
					longer[i] = sc.nextInt();
				}
				
				for(int i=0; i<M; i++) {
					shorter[i] = sc.nextInt();
				}
				
			}
		
			
			int res  = Integer.MIN_VALUE;
			
			for(int i=0; i<=longer.length-shorter.length; i++) { //긴배열 기준점
				int sum = 0;
				
				for(int j=0; j<shorter.length; j++) {
					sum += shorter[j] * longer[i+j];
					
				}
				
				if(sum > res) {
					res = sum;
				}
			
			}
			
			System.out.println("#" + t + " " + res);
		}
		
		

	}
	
	

}
