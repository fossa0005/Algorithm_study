package d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 요리사 {
	static int[][] sngy;
	static boolean[] added;
	static ArrayList<ArrayList<Integer>> groups; //[[a,b], [c,d], ......] 두그룹씩 조합
	static ArrayList<Integer> group1, group2;
	static int N;
	static int ans = 0;
	
	// N/2개(group1) + 나머지(group2) 고르는 메서드(dfs)
	//두그룹씩 꺼내서 시너지 계산해 최솟값 갱신
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			added = new boolean[N];
			groups = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			sngy = new int[N][N];
			
			//시너지표 입력
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					sngy[r][c] = sc.nextInt();
				}
			}
			
			// NC2 % 2
			// = 0번째 재료를 무조건 포함하여 N/2개 뽑는 경우의 수
			added[0] = true; 
			dfs(1, 1);
			
			
			for(int i=0; i<=groups.size()-2; i+=2) {
				group1 = groups.get(i);
				group2 = groups.get(i+1);
				
				int sngy1 = getSngy(group1);
				int sngy2 = getSngy(group2);
				int gap = Math.abs(sngy1 - sngy2);
				if(gap < ans) ans = gap;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	
	static void dfs(int start, int cnt) {
		
		if(cnt == N/2) {
			//System.out.println(Arrays.toString(added));
			
			ArrayList<Integer> group1 = new ArrayList<>();
			ArrayList<Integer> group2 = new ArrayList<>();
			for(int n=0; n<N; n++) {
				if(added[n]) group1.add(n);
				else group2.add(n);
			}
			groups.add(group1);
			groups.add(group2);
			return;
		}
			
		
		for(int j=start; j<N; j++) {
			added[j] = true;
			dfs(j+1, cnt+1);
			added[j] = false;
		}
	}
	
	static int getSngy(ArrayList<Integer> group) {
		int res = 0;
		
		for(int i : group) {
			for(int j : group) {
				if(i==j) continue;
				res += sngy[i][j];
			}
		}
		
		return res;
	}
	
	
}
