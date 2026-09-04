package d3;

import java.util.Scanner;

public class No12712_파리퇴치3_우식님 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 어차피 가로, 세로 다 뿌려보고 모든 경우의 최대를 구할것이므로 max는 공통으로 둬도 됩니다
			int max = 0;
			
			//(좌표평면을 다룰땐 i,j보다 y,x 또는 r,c 쓰는게 좋습니다)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					//1. 대각선
					int sum1 = 0;
					//a범위 예시: M이 3이면 a는 -2 ~ 2까지 움직임
					for(int a = -M+1; a < M; a++) { //우하향 대각선합(i j 둘다늚)
						if(i+a<0 || i+a>=N || j+a<0 || j+a>=N) continue; //인덱스 벗어나는 좌표는 세지않음
						sum1 += arr[i+a][j+a];
					}
					
					for(int a = -M+1; a < M; a++) { 
						if(i-a<0 || i-a>=N || j+a<0 || j+a>=N) continue; 
						sum1 += arr[i-a][j+a];   //우상향 대각선합(i줄고 j 늚)
					}
					
					sum1 -= arr[i][j]; //중심점 두번 세므로 하나제외
					
					if(sum1 > max) max=sum1;
				
				
					//2. 십자가
					int sum2 = 0;
					for(int a = -M+1; a < M; a++) { //수직합
						if(i+a<0 || i+a>=N ) continue;
						sum2 += arr[i+a][j];
					}
					
					for(int a = -M+1; a < M; a++) { //수평합
						if(j+a<0 || j+a>=N) continue;
						sum2 += arr[i][j+a];
					}
					
					sum2 -= arr[i][j]; //중심점 두번 세므로 하나제외
					if(sum2 > max) max=sum2;
							
				}
			}
			
			
			System.out.println("#" + tc + " " + max);
		}
			
	}
}
			
			
		
