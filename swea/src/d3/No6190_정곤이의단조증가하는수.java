package d3;


import java.util.Scanner;

public class No6190_정곤이의단조증가하는수 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			int n = sc.nextInt();
			int res = -1;
			int[] a = new int[n];
			
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					int num = a[i]*a[j];
					
					if (isIncreasing(num)) {
						if (num > res) {
							res = num;
						}
					}
					
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
		sc.close();
	}
	
	
	
	
	
	public static boolean isIncreasing(int num) {
		boolean ans  = true;
		char[] arr = String.valueOf(num).toCharArray();
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] > arr[i]) {
				ans = false;
				break;
			}
		}
		
		return ans;
	}

}
