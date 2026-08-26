package d2;

import java.util.Arrays;
import java.util.Scanner;

public class No1959_두개의숫자열 {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		//test
		//N M
		//N길이
		//M길이
		
		//M이 더 길게 세팅
		
		int test = sc.nextInt();
		for(int t=1; t<=test; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if (N > M) {
				int bigger = N;
				N = M;
				M = bigger;
			}
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			
			
			
			for(int i=0; i<N; i++) {
				arr1[i] = sc.nextInt();
			}
			
			for(int i=0; i<M; i++) {
				arr2[i] = sc.nextInt();
			}
			
			//System.out.println(Arrays.toString(arr1));
			//System.out.println(Arrays.toString(arr2));
			
			int res  = Integer.MIN_VALUE;
			
			for(int i=0; i<=M-N; i++) { //긴배열
				int sum = 0;
				
				for(int j=0; j<N; j++) {
					sum += arr1[j] * arr2[i+j];
				}
				
				if(sum > res) {
					res = sum;
				}
			
			}
			
			System.out.println("#" + t + " " + res);
		}
		
		

	}
	
	

}
