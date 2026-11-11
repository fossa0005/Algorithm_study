package A형기출;

import java.util.Arrays;
import java.util.Scanner;

public class No4012_요리사2 {
	static int N;
	static int[][] synergy;
	static boolean[] groupA; //A그룹이면 true
	static int tasteA, tasteB;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			synergy = new int[N][N];
			groupA = new boolean[N];
			res= Integer.MAX_VALUE;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					synergy[r][c] = sc.nextInt();
				}
			}
			
			groupA[0] = true; 
			dfs(1, 1);
			
			System.out.println("#" + t + " " + res);	
		}

	}
	
	//분할 경우의수
	public static void dfs(int start, int cnt) {
		if(cnt == N/2) {
			tasteA = 0;
			tasteB = 0;
			getTaste();
			//System.out.println(Arrays.toString(groupA));
			int gap = Math.abs(tasteA - tasteB);
			if(gap < res) res = gap;
			return;
		}
		
		/*
		if(start == N) {
			return;
		}
		*/
		
		
		for(int i=start; i<N; i++) {
			groupA[i] = true;
			//cnt+1번째 선택하는 재료는 다음 인덱스부터 고름
			dfs(i+1, cnt+1);
			groupA[i] = false;
		}
		
	}
	
	//음식 맛 구하기
	public static void getTaste() {
		
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				if(groupA[i] && groupA[j]) {
					tasteA += synergy[i][j];
					tasteA += synergy[j][i];
				}
				
				else if(groupA[i]==false && groupA[j]==false) {
					tasteB += synergy[i][j];
					tasteB += synergy[j][i];
				}
				
			}
		}
	}

	
}

