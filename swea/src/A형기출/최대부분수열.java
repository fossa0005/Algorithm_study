package A형기출;

import java.util.ArrayList;
import java.util.Scanner;

public class 최대부분수열 {
	static int[] nums;
	static ArrayList<Integer> sums; //길이 K 부분수열의 합들
	static int N, K;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 길이 K의 부분수열의 합들을 슬라이딩 윈도우로 구해 배열에 저장
		//2. 2개 조합 dfs로 최대값 갱신
		//배열에서 거리가 최소 k 차이나야 겹치지 않음
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			sums = new ArrayList<Integer>();
			nums = new int[N];
			max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			
			int sum=0;
			for(int i=0; i<K; i++) {
				sum += nums[i];
			}
			
			sums.add(sum);
			
			//슬라이딩윈도우
			for(int left=0, right=K; right<N; left++, right++) {
				sum -= nums[left];
				sum += nums[right];
				
				sums.add(sum);
			}
			
			//System.out.println(sums);
			
			for(int i=0; i<sums.size()-K; i++) {
				dfs(i, sums.get(i), 1);
			}
			
			System.out.println("#" + t + " " + max);
		}
			
		}
		
		//2개 조합 dfs
		static void dfs(int i, int sum, int cnt) {
			
			if(cnt == 2) {
				if(sum > max) {
					max = sum;
				}
				return;
			}
			
			//인덱스 최소 K 차이나야함
			for(int j=i+K; j<sums.size(); j++) {
				dfs(j, sum + sums.get(j), cnt+1);
			}
		}
}
