package d2;

import java.util.Scanner;

public class No2001_파리퇴치 {
	static int n, m;
	static int[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n][n];
			
			for (int i = 0 ; i < n ; i ++) {
				for(int j = 0; j <n ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int res =0;
			for(int a=0; a<=n-m; a++) {
				for(int b=0; b<=n-m; b++) { //(y=a,x=b)를 좌상단 꼭짓점으로 하여 파리 셈
					int cnt = countFly(a, b);
					if(cnt>res) {
						res = cnt;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
			
		}
		
	}
	
	
	
	public static int countFly(int a, int b) { 
		int cnt = 0;
		for(int y=a; y<a+m; y++) {
			for(int x=b; x<b+m; x++) {
				
				cnt += arr[y][x];
			}
		}
		
		return cnt;
		
		
	}
	
	
	

}
