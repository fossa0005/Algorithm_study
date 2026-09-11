package d4;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No2819_격자판의숫자이어붙이기 {
	static int[][] arr; 
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static Set<Integer> set;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			set = new HashSet<>();
			arr = new int[4][4];
			
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			
			
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					dfs(0, 0, r, c);
				}
			}
			
			//System.out.println(set);
			System.out.println("#" + t + " " + set.size());
		}
	}
	
	
	static void dfs(int cnt, int num, int r, int c) {
		if(cnt == 7) {
			set.add(num);
			return;
		}
		
		for(int i=0; i<4; i++) { 
			if(r+dr[i] < 0 || r+dr[i] >= 4 || c+dc[i] < 0 || c+dc[i] >= 4) continue;
			
			//지금 숫자 반영하고 다음 노드 넘어가기
			dfs(cnt+1, num + arr[r][c] * (int)Math.pow(10, cnt), r+dr[i], c+dc[i]);
		}
	}
	
}
