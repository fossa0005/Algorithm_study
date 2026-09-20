package d4;

import java.util.Arrays;
import java.util.Scanner;

public class No8275_햄스터 {
	static int[] cage; //N번까지의 햄스터수 배열
	static int[] prefixSum;
	static int N, X, M;
	static int maxSum;
	static int[] ans;
	static int[][] constraints; // [l, r, s], ...
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개 우리, 최대 X마리, M개 기록 
		//l번 우리에서 r번 우리까지 햄스터수 s마리
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			 X = sc.nextInt();
			 M = sc.nextInt();
			
			cage = new int[N];
			prefixSum = new int[N];
			maxSum = -1;
			ans = new int[N];
			constraints = new int[M][3];
			
			
			for(int m=0; m<M; m++) {
				constraints[m][0] = sc.nextInt()-1;
				constraints[m][1] = sc.nextInt()-1;
				constraints[m][2] = sc.nextInt();
			}
			
			for(int x=0; x<=X; x++) {
				cage[0] = x;
				prefixSum[0] = x;
				dfs(0, x);
			}
			
			if(maxSum == -1) { //갱신 한번도 안됨
				System.out.println("#" + t + " " + -1);
			}
			
			else {
				System.out.print("#" + t + " ");
				for(int i=0; i<N; i++) {
					System.out.print(ans[i] + " ");
				}
				System.out.println();
			}
		}	
	}
	
	
	static void dfs(int i, int sum) { //i번째 케이지, 총 햄스터수
		if(i == N-1) {
			if(isValid()) {
				if(sum > maxSum) {
					maxSum = sum;
					ans = Arrays.copyOf(cage, N);
				}
				
				else if(sum == maxSum) { //햄 수 같으면 사전순
					boolean flag = true;
					for(int n=0; n<N; n++) {
						if(cage[n] > ans[n]) {
							flag = false;
							break;
						}
						
						if(cage[n] < ans[n]) {
							break;
						}
					}
					
					if(flag) ans = Arrays.copyOf(cage, N);
				}
			}
			
			return;
		}
		
		for(int x=0; x<=X; x++) {
			cage[i+1] = x;
			prefixSum[i+1] = sum+x;
			dfs(i+1, sum+x);
		}
		
		
	}
	
	
	static boolean isValid() {
		boolean res = true;
		
		for(int[] constranit : constraints) {
			int l = constranit[0];
			int r = constranit[1];
			int s = constranit[2];
			
			if(l==0) {
				if(prefixSum[r] != s) {
					res = false;
					break;
				}
			}
			else {
				if(prefixSum[r] - prefixSum[l-1] != s) { 
					res = false;
					break;
				}
			}
		}
		return res;
	}
}
