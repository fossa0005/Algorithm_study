package d3;

import java.util.Scanner;

public class No1216_회문2 {
	static char[][] arr;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = 10;
		
		for(int tc=1; tc<=test; tc++) {
			int t = sc.nextInt();
			
			arr = new char[100][];
			for(int r=0; r<100; r++) {
				arr[r] = sc.next().toCharArray();
			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			ans = 1;
			for(int r=0; r<100; r++) {
				checkRow(r);
			}
			
			for(int c=0; c<100; c++) {
				checkCol(c);
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
		
		sc.close();
	
	}
		


	//한 행에서
	static void checkRow(int r) {
		//회문길이(긴것부터검사)
		for(int n=100; n>ans; n--) { 
			
				//시작점
				for(int start=0; start<=100-n; start++) { 
					boolean flag = true; //회문인지
					int p1, p2;
					char c1, c2;
					for(p1=start, p2 = start+n-1; p1<=p2; p1++, p2--) {
						c1 = arr[r][p1];
						c2 = arr[r][p2];
						if(c1 != c2) {
							flag = false;
							break;
						}
					}
					
					//회문 나오면 탐색종료	
					if(flag == true) {
						//System.out.println("row, n:" + n);
						ans=n; 
						return;
					}
				}
		
		}
		
	}
	
	
	static void checkCol(int c) {
		
		for(int n=100; n>ans; n--) { //회문길이(긴것부터검사)
			
				//시작점
				for(int start=0; start<=100-n; start++) { 
					boolean flag = true; //회문인지
					int p1, p2;
					char c1, c2;
					for(p1=start, p2 = start+n-1; p1<=p2; p1++, p2--) {
						c1 = arr[p1][c];
						c2 = arr[p2][c];
						if(c1 != c2) {
							flag = false;
							break;
						}
					}
					
					//회문 나오면 탐색종료	
					if(flag == true) {
						//System.out.println("col, n:" + n);
						ans=n; 
						return;
					}
				}
		
		}
		
	}
}
	
	
