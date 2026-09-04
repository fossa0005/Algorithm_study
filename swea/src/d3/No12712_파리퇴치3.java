package d3;

import java.util.Scanner;

public class No12712_파리퇴치3 {
	static int N, M;
	static int ans;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			N =  sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			ans = 0;		
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					sprayCross(r, c);
					sprayX(r, c);
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		}

	}
	
	
	static void sprayCross(int a, int b) { //중심점(a,b)
		int cnt=0;
		
		
		for(int r=a-M+1; r<a+M; r++) {
			if(r<0 || r>=N) continue;
			cnt += arr[r][b];
		}
		
		for(int c=b-M+1; c<b+M; c++) {
			if(c<0 || c>=N) continue;
			cnt += arr[a][c];
		}
		cnt -= arr[a][b];
		
		if(cnt > ans) ans=cnt;	
	}
	
	
	static void sprayX(int a, int b) {
		int cnt=0;
		for(int r=a-M+1, c=b-M+1; r<a+M; r++, c++) { //우하향대각선
			if(r<0 || r>=N || c<0 || c>=N) continue;
			cnt += arr[r][c];
		}
		
		for(int r=a+M-1, c=b-M+1; r>a-M; r--, c++) { //우상향대각선
			if(r<0 || r>=N || c<0 || c>=N) continue;
			cnt += arr[r][c];
		}
		cnt -= arr[a][b];
		
		if(cnt > ans) ans = cnt;
	}
	
}
